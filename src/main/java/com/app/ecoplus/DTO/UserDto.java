package com.app.ecoplus.DTO;

import com.app.ecoplus.entity.Conexao;
import com.app.ecoplus.entity.User;
import lombok.Data;

import java.io.Serializable;

@Data
public class UserDto  implements Serializable {

    private Long id;
    private String nomeCompleto;
    private String email;
    private String cidade;
    private String serviçoOferecido;
    private Integer Documento;

    public UserDto() {
    }


    public UserDto(User user) {
        this.id = user.getId();
        this.nomeCompleto = user.getNomeCompleto();
        this.email = user.getEmail();
        this.cidade = user.getCidade();
        this.serviçoOferecido = user.getServiçoOferecido();
        this.Documento = user.getDocumento();
    }
    public User  tranUser(){return new User( id,  nomeCompleto, email,  cidade, serviçoOferecido, Documento); }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    @Override
    public String toString() {
        return "UserDto{" +
                "id=" + id +
                ", nomeCompleto='" + nomeCompleto + '\'' +
                ", email='" + email + '\'' +
                ", cidade='" + cidade + '\'' +
                ", serviçoOferecido='" + serviçoOferecido + '\'' +
                ", Documento=" + Documento +
                '}';
    }
}
