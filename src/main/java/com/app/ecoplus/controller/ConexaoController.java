package com.app.ecoplus.controller;

import com.app.ecoplus.DTO.ConexaoDto;
import com.app.ecoplus.entity.Conexao;
import com.app.ecoplus.service.ConexaoService;
import com.app.ecoplus.service.Exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/api/conexao")
public class ConexaoController {



    @Autowired
    private ConexaoService conexaoService;

    //Criado
    @PostMapping
    public ResponseEntity<Conexao> salvar(@RequestBody ConexaoDto conexaoDto) {
        Conexao conexao = conexaoService.created(conexaoDto.transformaParaObjeto());
        return new ResponseEntity<>(conexao, HttpStatus.CREATED);
    }

    // Busca
    @GetMapping
    public ResponseEntity<List<ConexaoDto>> findAll() {
        List<Conexao> conexao = conexaoService.findAll();
        System.out.println("Conexoes: " + conexao); // Adicione um log
        List<ConexaoDto> conexaodto = conexao.stream().map(ConexaoDto::new).toList();
        return ResponseEntity.ok(conexaodto);
    }

    // Busca por id
    @GetMapping("/{id}")
    public ResponseEntity<ConexaoDto> findById(@PathVariable Long id) {
        Conexao conexao = conexaoService.findById(id);
        return ResponseEntity.ok().body(new ConexaoDto(conexao));
    }
    //Update
    @PutMapping("/{id}")
    public ResponseEntity<Void> updateConexao(@PathVariable Long id, @RequestBody ConexaoDto conexaoDto) {
        conexaoService.updateConexao(id, conexaoDto);
        return ResponseEntity.noContent().build();
    }

    // Deletar
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        try {
            conexaoService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (ObjectNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }


}
