package com.gate.gatewebapi.websocket;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor
public class LorawanPacket {
    private String cmd;
    @JsonProperty("EUI")
    private String EUI;
    private long ts;
    private String data;

}
