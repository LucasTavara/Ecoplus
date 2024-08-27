package com.app.ecoplus.dto.user;
import com.app.ecoplus.entity.user.UserRole;

public record UserRegisterAuthDto (
		String login,
		String password,
		String email,
		String nomeCompleto,
		String cidade,
		String servicoOferecido,
		String documento,
		UserRole role){
}
