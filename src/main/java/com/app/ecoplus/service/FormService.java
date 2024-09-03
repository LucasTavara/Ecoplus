package com.app.ecoplus.service;


import com.app.ecoplus.dto.FormDto;
import com.app.ecoplus.entity.Form;
import com.app.ecoplus.repository.FormRepository;
import com.app.ecoplus.service.exception.ObjectNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;



@Service
@RequiredArgsConstructor
public class FormService{

	
    private final FormRepository formRepository;
    
    //Uma lista do tipo User que retorna todos os usuários
    public List<Form> findAll() {
    	return formRepository.findAll();
    }


    //Busca por Id a Conexão estabelecida
    public Form findById(Long id) {
        return formRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Conexao not found with id: " + id));
    }

    public FormDto create(FormDto formDto) {
        try{
            Form form = formRepository.save(formDto.toForm(formDto));
            return formDto.toFormDto(form);
        }catch(Exception e){
            throw new ObjectNotFoundException("Object found exception");
        }
    }

    //Update
    public void updateForm(Long id, FormDto formDto) {
        Optional<Form> formOptional = formRepository.findById(id);
        if (formOptional.isEmpty()){
            throw new ObjectNotFoundException("Form not exist.");
        }
        Form form = formOptional.get();
        form.setNomeCompleto(formDto.getNomeCompleto());
        form.setEmpresa(formDto.getEmpresa());
        form.setCidade(formDto.getCidade());
        form.setEmail(formDto.getEmail());
        form.setMensagem(formDto.getMensagem());

        Form updatedForm = formRepository.save(form);
        formDto.toFormDto(updatedForm);
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