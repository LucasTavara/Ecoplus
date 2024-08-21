package com.app.ecoplus.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name="conexão")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Conexao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String empresa;
    private String cidade;
    private String email;
    private String mensagem;
    


}
