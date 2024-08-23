package com.app.ecoplus.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.ecoplus.DTO.FormDto;
import com.app.ecoplus.entity.Form;
import com.app.ecoplus.service.FormService;
import com.app.ecoplus.service.exception.ObjectNotFoundException;


@RestController
@RequestMapping("/form-api")
public class FormController {


    private final FormService formService;

    public FormController(FormService formService) {
    	this.formService = formService;
    }
    
    //Criado
    @PostMapping
    public ResponseEntity<Form> createForm(@RequestBody FormDto formDto) {
        Form form = formService.create(formDto.transformaParaObjeto());
        return new ResponseEntity<>(form, HttpStatus.CREATED);
    }

    // Busca
    @GetMapping("/")
    public ResponseEntity<List<FormDto>> findAll() {
        List<Form> form = formService.findAll();
        List<FormDto> formDto = form.stream().map(FormDto::new).toList();
        return ResponseEntity.ok(formDto);
    }

    // Busca por id
    @GetMapping("/{id}")
    public ResponseEntity<FormDto> findById(@PathVariable Long id) {
        Form form = formService.findById(id);
        return ResponseEntity.ok().body(new FormDto(form));
    }
    //Update
    @PutMapping("/{id}")
    public ResponseEntity<Void> updateForm(@PathVariable Long id, @RequestBody FormDto formDto) {
        formService.updateForm(id, formDto);
        return ResponseEntity.noContent().build();
    }

    // Deletar
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        try {
            formService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (ObjectNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }


}