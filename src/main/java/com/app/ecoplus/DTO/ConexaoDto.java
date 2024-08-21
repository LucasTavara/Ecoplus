package com.app.ecoplus.DTO;

import com.app.ecoplus.entity.Conexao;

import lombok.Data;


import java.io.Serializable;

@Data
public class ConexaoDto implements Serializable {

    private Long id;

    private String nome;
    private String empresa;
    private String email;
    private String cidade;
    private String mensagem;

    public ConexaoDto(Long id, String nome, String empresa, String email, String cidade, String mensagem) {
        this.id = id;
        this.nome = nome;
        this.empresa = empresa;
        this.email = email;
        this.cidade = cidade;
        this.mensagem = mensagem;
    }

    public ConexaoDto(Conexao conexao) {
        this.id = conexao.getId();
        this.nome = conexao.getNome();
        this.empresa = conexao.getEmpresa();
        this.email = conexao.getEmail();
        this.cidade = conexao.getCidade();
        this.mensagem = conexao.getMensagem();
    }



    public Conexao transformaParaObjeto(){
        return new Conexao(id,nome,empresa,cidade, email, mensagem);
    }

    public Long getId() {return id;}

    public void setId(Long id) {this.id = id;}

    public String getNome() {return nome;}

    public void setNome(String nome) {this.nome = nome;}

    public String getEmpresa() {return empresa;}

    public void setEmpresa(String empresa) {this.empresa = empresa;}

    public String getEmail() {return email;}

    public void setEmail(String email) {this.email = email;}

    public String getCidade() {return cidade;}

    public void setCidade(String cidade) {this.cidade = cidade;}

    public String getMensagem() {return mensagem;}

    public void setMensagem(String mensagem) {this.mensagem = mensagem;}

    @Override
    public String toString() {
        return "ConexaoDto{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", empresa='" + empresa + '\'' +
                ", email='" + email + '\'' +
                ", cidade='" + cidade + '\'' +
                ", mensagem='" + mensagem + '\'' +
                '}';
    }
}
