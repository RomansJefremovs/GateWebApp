package com.gate.gatewebapi.controller;

import com.gate.gatewebapi.service.MeasurementService;
import com.gate.gatewebapi.service.dto.MeasurementDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users/{userId}/terrariums/{tId}/measurements")
public class MeasurementsController {
    @Autowired
    private MeasurementService measurementService;

    @PostMapping
    public MeasurementDto addMeasurement(@PathVariable Long tId, @RequestBody MeasurementDto measurementDto){
        return measurementService.addMeasurement(tId,measurementDto);
    }

    @GetMapping
    public List<MeasurementDto> getForTerrarium(@PathVariable Long tId){
        return measurementService.getForTerrarium(tId);
    }
}
