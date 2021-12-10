package com.gate.gatewebapi.persistance;

import com.gate.gatewebapi.domain.Measurement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MeasurementRepository extends JpaRepository<Measurement, Long> {
    List<Measurement> findByTerrariumId(Long id);

}
