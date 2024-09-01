package com.app.ecoplus.dto.user;
import com.app.ecoplus.entity.user.UserRole;

public record UserRegisterAuthDto (
		 String email
		,String password
		,String nomeCompleto
		,String phone
		,String age
		,String endereco
		,String documento
		,UserRole role){
}
