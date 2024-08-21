package com.app.ecoplus.entity;

import java.time.LocalDate;

import jakarta.persistence.*;
<<<<<<< HEAD
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
=======
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
>>>>>>> b479bd4d71bfdf48fa87740c487dcc9eb0e471f6

@Entity
@Table(name = "user")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String nomeCompleto;
    @NotBlank
    private String email;
    @NotBlank
    private String cidade;
    @NotBlank
    private String serviçoOferecido;
    @NotBlank
    private Integer Documento;

<<<<<<< HEAD

=======
>>>>>>> b479bd4d71bfdf48fa87740c487dcc9eb0e471f6
    

}
