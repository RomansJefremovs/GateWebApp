package com.gate.gatewebapi.persistance;

import com.gate.gatewebapi.domain.RecommendedConditions;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecommendedRepository extends JpaRepository<RecommendedConditions, Long> {

}
