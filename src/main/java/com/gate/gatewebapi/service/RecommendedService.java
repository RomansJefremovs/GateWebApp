package com.gate.gatewebapi.service;

import com.gate.gatewebapi.domain.RecommendedConditions;
import com.gate.gatewebapi.persistance.RecommendedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecommendedService {
    @Autowired
    private RecommendedRepository recommendedRepository;

    public RecommendedConditions create(RecommendedConditions recommendedConditions){
        return recommendedRepository.save(recommendedConditions);
    }
    public List<RecommendedConditions> getAll(){
        return recommendedRepository.findAll();
    }

    public RecommendedConditions update(Long rId, RecommendedConditions updated){
        RecommendedConditions rec = recommendedRepository.getById(rId);
        rec.setCo2(updated.getCo2());
        rec.setTemperature(updated.getTemperature());
        rec.setHumidity(updated.getHumidity());
        rec.setName(updated.getName());
        return recommendedRepository.save(rec);

    }
}
