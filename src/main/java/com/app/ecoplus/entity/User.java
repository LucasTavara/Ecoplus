package com.app.ecoplus.entity;

import java.time.LocalDate;

import jakarta.persistence.*;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomeCompleto;
    private String email;
    private String cidade;
    private String serviçoOferecido;
    private Integer Documento;




    
	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getServiçoOferecido() {
        return serviçoOferecido;
    }

    public void setServiçoOferecido(String serviçoOferecido) {
        this.serviçoOferecido = serviçoOferecido;
    }

    public Integer getDocumento() {
        return Documento;
    }

    public void setDocumento(Integer documento) {
        Documento = documento;
    }
}
