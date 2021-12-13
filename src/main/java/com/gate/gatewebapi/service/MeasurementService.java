package com.gate.gatewebapi.service;

import com.gate.gatewebapi.domain.Measurement;
import com.gate.gatewebapi.domain.Terrarium;
import com.gate.gatewebapi.persistance.MeasurementRepository;
import com.gate.gatewebapi.persistance.TerrariumRepository;
import com.gate.gatewebapi.service.dto.MeasurementDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MeasurementService {
    @Autowired
    private MeasurementRepository measurementRepository;
    @Autowired
    private TerrariumRepository terrariumRepository;

    public MeasurementDto addMeasurement(Long tId, MeasurementDto measurementDto){
       Terrarium t = terrariumRepository.getById(tId);
       Measurement measurement = new Measurement(null,measurementDto.getCo2(),
               measurementDto.getTemperature(),
               measurementDto.getHumidity(),
               measurementDto.getTimestamp(),t);
       measurementRepository.save(measurement);
       return toDto(measurement);
    }

    public List<MeasurementDto> getForTerrarium(Long tId){
        return measurementRepository.findByTerrariumId(tId)
                .stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }
    private MeasurementDto toDto(Measurement entity){
        return new MeasurementDto(entity.getId(),
                entity.getCo2(),
                entity.getTemperature(),
                entity.getHumidity(),
                entity.getTimestampMilis());
    }
}
