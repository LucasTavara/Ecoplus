package com.app.ecoplus.controller;

import com.app.ecoplus.dto.FormDto;
import com.app.ecoplus.entity.Form;
import com.app.ecoplus.service.FormService;
import com.app.ecoplus.service.exception.ObjectNotFoundException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/form-api")
@RequiredArgsConstructor
public class FormController {


    private final FormService formService;

    //Criado
    @PostMapping(value = "/create", produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FormDto> createForm(@RequestBody @Valid FormDto formDto) {
        return ResponseEntity.ok(formService.create(formDto));
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
        try{
            formService.updateForm(id, formDto);
            return ResponseEntity.status(HttpStatus.OK).build();
        }catch (Exception e){
            throw new ObjectNotFoundException("Teste");
        }
    }

    // Deletar
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        try {
            formService.delete(id);
            return ResponseEntity.ok().build();
        } catch (ObjectNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    //Tratariva de erro BAD_REQUEST na requisição
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach(error -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }

}