package com.app.ecoplus.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "User")
@Data
@NoArgsConstructor
public class User {

	
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomeCompleto;
    private String email;
    private String cidade;
    private String servicoOferecido;
    private String documento;
}
