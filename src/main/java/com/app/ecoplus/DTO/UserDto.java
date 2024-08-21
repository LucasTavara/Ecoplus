package com.app.ecoplus.DTO;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

public class UserDto {

    private Long id;
    private String nome;
    private String email;
    private Integer Documento;

    public UserDto() {
    }

    public UserDto(Long id, String nome, String email) {
        this.id = id;
        this.nome = nome;
        this.email = email;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getDocumento() {
        return Documento;
    }

    public void setDocumento(Integer documento) {
        Documento = documento;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", documento=" + Documento +
                '}';
    }
}
