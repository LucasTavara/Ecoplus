package com.app.ecoplus.entity;
import java.time.LocalDate;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
    private String servicoOferecido;
    private String documento;
}
