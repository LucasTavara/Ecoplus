package com.app.ecoplus.DTO;

import jakarta.persistence.GeneratedValue;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record RegisterRequestDto(
		@NotNull String nomeCompleto
		,@NotBlank String email
		,@NotBlank String senha
		,@NotBlank String cidade
		,@NotBlank String servicoOferecido
		,@NotNull Integer documento) {
}
