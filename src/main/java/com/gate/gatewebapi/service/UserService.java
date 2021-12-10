package com.gate.gatewebapi.service;

import com.gate.gatewebapi.domain.User;
import com.gate.gatewebapi.persistance.UserRepository;
import com.gate.gatewebapi.service.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;


    public UserDto register(UserDto userDto){
        User user = new User();
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
       return toDto(repository.save(user));
    }

    public UserDto logIn(UserDto user){
        User u = repository.findByEmail(user.getEmail());
        if ( u == null){
            throw new IllegalArgumentException();
        }
        if (u.getPassword().equals(user.getPassword())){
            return toDto(u);
        }
        throw new IllegalArgumentException();
    }
    private UserDto toDto(User entity){
        return new UserDto(entity.getId(), entity.getEmail(), entity.getPassword());
    }
}
