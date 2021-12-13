package com.gate.gatewebapi.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TerrariumDto {
    private Long id;
    private String name;
    private String deviceId;
    private Long recommendedId;
}
