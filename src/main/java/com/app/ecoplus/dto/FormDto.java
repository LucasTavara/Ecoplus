package com.app.ecoplus.dto;


import com.app.ecoplus.entity.Form;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
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
        return new Form(null, nomeCompleto, empresa, cidade, email, mensagem);
    }
    
    
    public FormDto(Form form) {
        this.id = form.getId();
        this.nomeCompleto = form.getNomeCompleto();
        this.empresa = form.getEmpresa();
        this.email = form.getEmail();
        this.cidade = form.getCidade();
        this.mensagem = form.getMensagem();
    }

    public Form toForm(FormDto formDto){
        Form form = new Form();
        form.setId(formDto.getId());
        form.setNomeCompleto(formDto.getNomeCompleto());
        form.setEmpresa(formDto.getEmpresa());
        form.setCidade(formDto.getCidade());
        form.setEmail(formDto.getEmail());
        form.setMensagem(formDto.getMensagem());
        return form;
    }


    public FormDto toFormDto(Form form){
        FormDto formDto = new FormDto();
        formDto.setId(form.getId());
        formDto.setNomeCompleto(form.getNomeCompleto());
        formDto.setEmpresa(form.getEmpresa());
        formDto.setCidade(form.getCidade());
        formDto.setEmail(form.getEmail());
        formDto.setMensagem(form.getMensagem());
        return formDto;
    }


}
