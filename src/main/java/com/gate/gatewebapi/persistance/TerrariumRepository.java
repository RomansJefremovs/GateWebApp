package com.gate.gatewebapi.persistance;

import com.gate.gatewebapi.domain.Terrarium;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TerrariumRepository extends JpaRepository<Terrarium, Long> {

}
