package com.app.ecoplus.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Entity
@Table(name = "Users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String nomeCompleto;
    @NotBlank
    private String  senha;
    @NotBlank
    private String email;
    @NotBlank
    private String cidade;
    @NotBlank
    private String estado;

    private String servicoOferecido;
    @NotNull
    private Integer documento;




}
