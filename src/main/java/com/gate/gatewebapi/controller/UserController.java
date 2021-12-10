package com.gate.gatewebapi.controller;

import com.gate.gatewebapi.domain.User;
import com.gate.gatewebapi.service.UserService;
import com.gate.gatewebapi.service.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public UserDto register(@RequestBody UserDto user){
        return userService.register(user);
    }
    @PostMapping("/login")
    public UserDto logIn(@RequestBody UserDto user){
        return userService.logIn(user);
    }
}
