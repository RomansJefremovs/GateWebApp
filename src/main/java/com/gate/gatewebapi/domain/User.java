package com.gate.gatewebapi.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name="Account")
public class User {
    @Id @GeneratedValue
    private Long id;
    private String email;
    private String password;
    @OneToMany
    private List<Terrarium> terrariums;
}
