package com.app.ecoplus.mapper;

import com.app.ecoplus.DTO.UserDto;
import com.app.ecoplus.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    // UserDto para User
    public User toUser(UserDto userDto) {
        if (userDto == null) {
            return null;
        }
        User user = new User();
        user.setId(userDto.getId());
        user.setNomeCompleto(userDto.getNomeCompleto());
        user.setSenha(userDto.getSenha());
        user.setEmail(userDto.getEmail());
        user.setCidade(userDto.getCidade());
        user.setServicoOferecido(userDto.getServicoOferecido());
        user.setDocumento(userDto.getDocumento());
        return user;
    }

    // User para UserDto
    public UserDto toUserDto(User user) {
        if (user == null) {
            return null;
        }
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setNomeCompleto(user.getNomeCompleto());
        userDto.setSenha(user.getSenha());
        userDto.setEmail(user.getEmail());
        userDto.setCidade(user.getCidade());
        userDto.setServicoOferecido(user.getServicoOferecido());
        userDto.setDocumento(user.getDocumento());
        return userDto;
    }
}