package com.app.ecoplus.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name="forms")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Form {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String nomeCompleto;
    @NotBlank
    private String empresa;
    @NotBlank
    private String cidade;
    @NotBlank
    private String email;
    @NotBlank
    private String mensagem;



}