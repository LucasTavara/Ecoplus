package com.app.ecoplus.dto.email;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmailDto implements Serializable {
    private String nomeCompleto;
    private String empresa;
    private String email;
    private String cidade;
    private String mensagem;



}
