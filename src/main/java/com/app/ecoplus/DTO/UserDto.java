package com.app.ecoplus.DTO;

import java.io.Serializable;

import com.app.ecoplus.entity.User;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto implements Serializable{

	// Checar depois.
	private static final long serialVersionUID = 1L;
	private Long id;
    private String nomeCompleto;
    private String senha;
    private String email;
    private String cidade;
    private String estado;
    private String servicoOferecido;
    private Integer documento;


    public UserDto(User user) {
        this.id = id;
        this.nomeCompleto = nomeCompleto;
        this.senha = senha;
        this.email = email;
        this.cidade = cidade;
        this.estado = estado;
        this.servicoOferecido = servicoOferecido;
        this.documento = documento;
    }

    public User transformaParaObjeto() {
        return
                new User(null,nomeCompleto,senha,email,cidade,estado,servicoOferecido,documento);
    }
}


