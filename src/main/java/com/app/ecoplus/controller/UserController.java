package com.app.ecoplus.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.ecoplus.DTO.UserDto;
import com.app.ecoplus.entity.User;
import com.app.ecoplus.service.UserService;
import com.app.ecoplus.util.UserMapper;

@RestController
@RequestMapping("/user")
public class UserController {
    
    private final UserService userService;
    private final UserMapper userMapper;
    
    public UserController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }
    
    // Create
    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {
        UserDto createdUserDto = userService.createUser(userDto);
        return ResponseEntity.ok(createdUserDto);
    }    // Read
    
    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUser() {
        List<User> users = userService.getAllUser();
        List<UserDto> userDtos = users.stream()
                                      .map(userMapper::toDto)
                                      .collect(Collectors.toList());
        return ResponseEntity.ok(userDtos);
    }
    
    // Read by ID
    @GetMapping("/findById/{id}")
    public ResponseEntity<UserDto> findById(@PathVariable Long id) {
        return userService.findById(id)
                .map(userDto -> ResponseEntity.ok(userDto))
                .orElse(ResponseEntity.notFound().build());
    }

    // Update
    @PutMapping("/update/{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable Long id, @RequestBody UserDto userDto) {
        if (!userService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        UserDto updatedUserDto = userService.updateUser(id, userDto);
        return ResponseEntity.ok(updatedUserDto);
    }

    // Delete
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
    
    // Read by name and ID
    @GetMapping("/idandname/{id}/{nomeCompleto}")
    public ResponseEntity<UserDto> showIdAndName(@PathVariable Long id, @PathVariable String nomeCompleto) {
        return userService.idAndName(id, nomeCompleto)
                .map(userDto -> ResponseEntity.ok(userDto))
                .orElse(ResponseEntity.notFound().build());
    }
    
    // Read by name
    @GetMapping("/byNome/{nomeCompleto}")
    public ResponseEntity<List<UserDto>> findByNome(@PathVariable String nomeCompleto) {
        List<UserDto> userDtos = userService.findByNomeCompleto(nomeCompleto).stream()
                .map(userMapper::toDto)
                .collect(Collectors.toList());
        if (userDtos.isEmpty()) {
            return ResponseEntity.noContent().build(); 
        }else {
            return ResponseEntity.ok(userDtos);
        }
    }
}
