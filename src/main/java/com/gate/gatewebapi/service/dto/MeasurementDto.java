package com.gate.gatewebapi.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MeasurementDto {
    private Long id;
    private int co2;
    private int temperature;
    private int humidity;
    private LocalDateTime timestamp;
}
