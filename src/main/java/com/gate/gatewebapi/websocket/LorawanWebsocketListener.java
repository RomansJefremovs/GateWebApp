package com.gate.gatewebapi.websocket;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gate.gatewebapi.service.MeasurementService;
import com.gate.gatewebapi.service.TerrariumService;
import com.gate.gatewebapi.service.dto.MeasurementDto;
import com.gate.gatewebapi.service.dto.TerrariumDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketHttpHeaders;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.client.WebSocketClient;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.net.URI;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.concurrent.ExecutionException;

@Component
public class LorawanWebsocketListener extends TextWebSocketHandler {
    private ObjectMapper mapper;
    private MeasurementService measurmentService;
    private TerrariumService terrariumService;

    public LorawanWebsocketListener(@Value("${lorawanWebsocketUrl}") String url,
                                    ObjectMapper mapper,
                                    MeasurementService measurementService,
                                    TerrariumService terrariumService) throws ExecutionException, InterruptedException {
        this.mapper = mapper;
        this.measurmentService = measurementService;
        this.terrariumService = terrariumService;
        WebSocketClient client = new StandardWebSocketClient();
        client.doHandshake(this, new WebSocketHttpHeaders(), URI.create(url)).get();
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession ws) {
        System.out.println("Websocket connected");
    }

    @Override
    protected void handleTextMessage(WebSocketSession ws, TextMessage text) {
       try {
           LorawanPacket packet = mapper.readValue(text.getPayload(), LorawanPacket.class);
           if (packet.getCmd().equals("rx") && packet.getData() != null) {
               TerrariumDto t = terrariumService.getByDeviceId(packet.getEUI());
               MeasurementDto m = parseMeasurement(packet.getData());
               m.setTimestamp(packet.getTs());
               measurmentService.addMeasurement(t.getId(), m);
           }
           System.out.println(text.getPayload());
       }catch (JsonProcessingException ex){
           throw new RuntimeException(ex);
       }
    }

    private MeasurementDto parseMeasurement(String payload) {
        MeasurementDto m = new MeasurementDto();
        m.setHumidity(Integer.parseInt(payload.substring(0, 4), 16));
        m.setTemperature(Integer.parseInt(payload.substring(4, 8), 16));
        m.setCo2(Integer.parseInt(payload.substring(8, 12), 16));
        return m;
    }
}
