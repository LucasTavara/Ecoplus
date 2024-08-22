package com.app.ecoplus.util;

import org.springframework.stereotype.Component;

import com.app.ecoplus.DTO.UserDto;
import com.app.ecoplus.entity.User;

@Component
public class UserMapper {


    public UserDto toDto(User user) {
        return new UserDto(
            user.getId(),
            user.getNomeCompleto(),
            user.getEmail(),
            user.getCidade(),
            user.getServicoOferecido(),
            user.getDocumento()
        );
    }

    public User toEntity(UserDto userDto) {
        User user = new User();  
    	user.setId(userDto.getId());
    	user.setNomeCompleto(userDto.getNomeCompleto());
    	user.setEmail(userDto.getEmail());
    	user.setCidade(userDto.getCidade());
    	user.setServicoOferecido(userDto.getServicoOferecido());
    	user.setDocumento(userDto.getDocumento());
    	return user;
    }
}

