package com.gate.gatewebapi.controller;

import com.gate.gatewebapi.domain.Terrarium;
import com.gate.gatewebapi.service.TerrariumService;
import com.gate.gatewebapi.service.dto.TerrariumDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users/{userId}/terrariums")
public class TerrariumController {
    @Autowired
    private TerrariumService terrariumService;

    @PostMapping
    public TerrariumDto create(@PathVariable Long userId, @RequestBody TerrariumDto terrariumDto){
        return terrariumService.create(userId,terrariumDto);
    }

    @PutMapping("/{id}")
    public TerrariumDto update(@PathVariable Long id, @RequestBody TerrariumDto terrariumDto){
        return terrariumService.update(id,terrariumDto);
    }

    @GetMapping
    public List<TerrariumDto> getForUser(@PathVariable Long userId){
        return terrariumService.getForUser(userId);
    }
}
