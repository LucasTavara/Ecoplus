package com.app.ecoplus.mapper;

import org.springframework.stereotype.Component;

import com.app.ecoplus.dto.user.UserDto;
import com.app.ecoplus.entity.user.User;

@Component
public class UserMapper {

    // UserDto para User
    public User toUser(UserDto userDto) {
        if (userDto == null) {
            return null;
        }
        User user = new User();
        user.setId(userDto.getId());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setNomeCompleto(userDto.getNomeCompleto());
        user.setPhone(userDto.getPhone());
        user.setAge(userDto.getAge());
        user.setEndereco(userDto.getEndereco());
        user.setDocumento(userDto.getDocumento());
        user.setRole(userDto.getRole());
        return user;
    }

    // User para UserDto
    public UserDto toUserDto(User user) {
        if (user == null) {
            return null;
        }
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setEmail(user.getEmail());
        userDto.setPassword(user.getPassword());
        userDto.setNomeCompleto(user.getNomeCompleto());
        userDto.setPhone(user.getPhone());
        userDto.setAge(user.getAge());
        userDto.setEndereco(user.getEndereco());
        userDto.setDocumento(user.getDocumento());
        userDto.setRole(user.getRole());
        return userDto;
    }
}