package com.gate.gatewebapi.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Entity
@AllArgsConstructor
public class Measurement {
    @Id @GeneratedValue
    private Long id;
    private int co2;
    private int temperature;
    private int humidity;
    private LocalDateTime timestamp;
    @ManyToOne
    private Terrarium terrarium;



}
