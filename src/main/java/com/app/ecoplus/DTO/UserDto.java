package com.app.ecoplus.DTO;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

public class UserDto {

    private Long id;
    private String nome;
    private String email;
    
    // Formatando data para dia-mês-ano
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate dataDeNascimento;

    public UserDto() {
    }

    public UserDto(Long id, String nome, String email, LocalDate dataDeNascimento) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.dataDeNascimento = dataDeNascimento;
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

    public LocalDate getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(LocalDate dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", dataDeNascimento=" + dataDeNascimento +
                '}';
    }
}
