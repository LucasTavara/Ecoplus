package com.app.ecoplus.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {


    private Long id;
    private String nomeCompleto;
    private String email;
    private String cidade;
    private String servicoOferecido;
    private String documento;
}