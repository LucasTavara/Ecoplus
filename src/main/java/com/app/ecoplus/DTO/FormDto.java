package com.app.ecoplus.DTO;


import java.io.Serializable;

import com.app.ecoplus.entity.Form;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class FormDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	
    private String nomeCompleto;
    private String empresa;
    private String email;
    private String cidade;
    private String mensagem;
    

    public Form transformaParaObjeto(){
        return new Form(id,nomeCompleto,empresa,cidade, email, mensagem);
    }
    
    public FormDto(Form form) {
        this.id = form.getId();
        this.nomeCompleto = form.getNome();
        this.empresa = form.getEmpresa();
        this.email = form.getEmail();
        this.cidade = form.getCidade();
        this.mensagem = form.getMensagem();
    }
	public FormDto(Long id, String nomeCompleto, String empresa, String email, String cidade, String mensagem) {
		super();
		this.id = id;
		this.nomeCompleto = nomeCompleto;
		this.empresa = empresa;
		this.email = email;
		this.cidade = cidade;
		this.mensagem = mensagem;
	}
	


}
