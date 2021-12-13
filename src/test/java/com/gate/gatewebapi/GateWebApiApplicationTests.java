package com.gate.gatewebapi;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gate.gatewebapi.service.dto.MeasurementDto;
import com.gate.gatewebapi.websocket.LorawanPacket;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

@SpringBootTest
class GateWebApiApplicationTests {
    @Test
    void contextLoads() {
    }


}
