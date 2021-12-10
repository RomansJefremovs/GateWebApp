package com.gate.gatewebapi.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@Entity
public class RecommendedConditions {
    @Id @GeneratedValue
    private Long id;
    private String name;
    private int co2;
    private int temperature;
    private int humidity;

}
