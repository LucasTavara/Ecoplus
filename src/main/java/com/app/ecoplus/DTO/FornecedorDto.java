package com.app.ecoplus.DTO;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FornecedorDto implements Serializable {

	// Checar depois.
	private static final long serialVersionUID = 1L;
	private Long id;
    private String nomeCompleto;
    private String email;
    private String estado;
    private String cidade;
    private String servicoOferecido;
    private Integer documento;

}
