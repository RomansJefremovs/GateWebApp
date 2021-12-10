package com.gate.gatewebapi.controller;

import com.gate.gatewebapi.domain.RecommendedConditions;
import com.gate.gatewebapi.service.RecommendedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/recommended")
public class RecommendedController {
    @Autowired
    private RecommendedService recommendedService;

    @PostMapping
    public RecommendedConditions create(@RequestBody RecommendedConditions rec){
        return recommendedService.create(rec);
    }
    @GetMapping
    public List<RecommendedConditions> getAll(){
        return recommendedService.getAll();
    }

    @PutMapping("{rId}")
    public RecommendedConditions update(@PathVariable Long rId, @RequestBody RecommendedConditions updated){
        return recommendedService.update(rId,updated);
    }
}
