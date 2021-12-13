package com.gate.gatewebapi.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Data
@NoArgsConstructor
@Entity
public class Terrarium {
    @Id @GeneratedValue
    private Long id;
    private String name;
    private String deviceId;
    @ManyToOne
    private RecommendedConditions recommendedConditions;
}
