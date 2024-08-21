package com.app.ecoplus.controller;


import com.app.ecoplus.DTO.UserDto;

import com.app.ecoplus.entity.User;

import com.app.ecoplus.service.Exception.ObjectNotFoundException;
import com.app.ecoplus.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/user")
public class UserController {



    @Autowired
    private UserService userService;

    //Criado
    @PostMapping
    public ResponseEntity<User> created(@RequestBody UserDto userDto) {
        User user = userService.created(userDto.tranUser());
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    // Busca
    @GetMapping
    public ResponseEntity<List<UserDto>> findAll() {
        List<User> users = userService.salvar();
        System.out.println("Conexoes: " + users); // Adicione um log
        List<UserDto> userDtos = users.stream().map(UserDto::new).toList();
        return ResponseEntity.ok(userDtos);
    }

    // Busca por id
    @GetMapping("/{id}")
    public ResponseEntity<UserDto> findById(@PathVariable Long id) {
        User user = userService.findById(id);
        return ResponseEntity.ok().body(new UserDto(user));
    }
    //Update
    @PutMapping("/{id}")
    public ResponseEntity<Void> updateUser(@PathVariable Long id, @RequestBody UserDto userDto) {
        userService.updateUser(id, userDto);
        return ResponseEntity.noContent().build();
    }

    // Deletar
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        try {
            userService.deleteUser(id);
            return ResponseEntity.noContent().build();
        } catch (ObjectNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }


}
