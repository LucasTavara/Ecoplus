package com.app.ecoplus.DTO;

public record RegisterRequestDto(String nomeCompleto, String email, String senha,String cidade,String estado,String servicoOferecido,Integer documento) {
}
