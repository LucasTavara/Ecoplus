package com.app.ecoplus.service;


import java.util.List;

import org.hibernate.ObjectNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.app.ecoplus.dto.FormDto;
import com.app.ecoplus.entity.Form;
import com.app.ecoplus.repository.FormRepository;



@Service
public class FormService{

	
    private final FormRepository formRepository;
    
    public FormService(FormRepository formRepository) {
    	this.formRepository = formRepository;
    }
    

    //Uma lista do tipo User que retorna todos os usuários
    public List<Form> findAll() {
    	return formRepository.findAll();}


    //Busca por Id a Conexão estabelecida
    public Form findById(Long id) {
        return formRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Conexao not found with id: " + id, id));
    }

    // Criação um novo usuário com todas as informações necessárias e salvar o mesmo no banco de dados
    public Form create(Form form) {
    	return formRepository.save(form);}

    //Update
    public ResponseEntity<?> updateForm(Long id, FormDto formDto) {
        var formEntityOptional = formRepository.findById(id);
        var form = formEntityOptional.get();


        if (!formEntityOptional.isEmpty()) {
            if (formDto.getNomeCompleto() != null) {
                form.setNome(formDto.getNomeCompleto());
            }
            else if (formDto.getEmail() != null) {
                form.setEmail(formDto.getEmail());
            }
            else if (formDto.getCidade() != null) {
                form.setCidade(formDto.getCidade());
            }
            else if (formDto.getEmpresa() != null) {
                form.setEmpresa(formDto.getEmpresa());
            }
            else if (formDto.getMensagem() != null) {
                form.setMensagem(formDto.getMensagem());
            }
            formRepository.save(form);
            return ResponseEntity.ok("Conexão atualizada com sucesso");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Conexão não encontrada");
        }
    }

    //Delete
    public void delete(Long id) {
    	  if (formRepository.existsById(id)) {
              formRepository.deleteById(id);
          } else {
              throw new RuntimeException("Form not found");
          }
    }

}