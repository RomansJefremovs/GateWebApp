package com.gate.gatewebapi.service;

import com.gate.gatewebapi.domain.Terrarium;
import com.gate.gatewebapi.domain.User;
import com.gate.gatewebapi.persistance.RecommendedRepository;
import com.gate.gatewebapi.persistance.TerrariumRepository;
import com.gate.gatewebapi.persistance.UserRepository;
import com.gate.gatewebapi.service.dto.TerrariumDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TerrariumService {

    @Autowired
    private TerrariumRepository terrariumRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RecommendedRepository recommendedRepository;

    public TerrariumDto create(Long uId,TerrariumDto terrariumDto){
        User owner = userRepository.getById(uId);
        Terrarium temp = new Terrarium();
        temp.setName(terrariumDto.getName());
        temp.setRecommendedConditions(recommendedRepository.getById(terrariumDto.getRecommendedId()));
        temp.setDeviceId(terrariumDto.getDeviceId());
        terrariumRepository.save(temp);
        owner.getTerrariums().add(temp);
        userRepository.save(owner);
        terrariumDto.setId(temp.getId());
        return terrariumDto;
    }

    public List<TerrariumDto> getForUser(Long userId){
        return userRepository.getById(userId).getTerrariums().stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    public TerrariumDto update(Long id, TerrariumDto terrariumDto){
        Terrarium entity = terrariumRepository.getById(id);
        entity.setName(terrariumDto.getName());
        entity.setRecommendedConditions(recommendedRepository.getById(terrariumDto.getRecommendedId()));
        terrariumRepository.save(entity);
        return toDto(entity);
    }
    public TerrariumDto getByDeviceId(String deviceId){
        return toDto(terrariumRepository.findByDeviceId(deviceId));
    }

    private TerrariumDto toDto(Terrarium t){
        return new TerrariumDto(t.getId(), t.getName(),t.getDeviceId(),t.getRecommendedConditions().getId());
    }
}
