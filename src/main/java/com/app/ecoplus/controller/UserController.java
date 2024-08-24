package com.app.ecoplus.controller;



import com.app.ecoplus.DTO.LoginRequestDto;
import com.app.ecoplus.DTO.RegisterRequestDto;
import com.app.ecoplus.DTO.ResponseDto;
import com.app.ecoplus.DTO.UserDto;

import com.app.ecoplus.entity.User;

import com.app.ecoplus.repository.UserRepository;
import com.app.ecoplus.security.TokenService;
import com.app.ecoplus.service.UserService;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

	private final UserService userService;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final TokenService tokenService;

    //Created
    @PostMapping("/login")
    public ResponseEntity login(@RequestBody LoginRequestDto body){
        User user = this.userRepository.findByEmail(body.email()).orElseThrow(() -> new RuntimeException("User not found"));
        if(passwordEncoder.matches(body.senha(), user.getSenha())) {
            String token = this.tokenService.generateToken(user);
            return ResponseEntity.ok(new ResponseDto(user.getEmail(), token));
        }
        return ResponseEntity.badRequest().build();
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody RegisterRequestDto body){
        Optional<User> user = this.userRepository.findByEmail(body.email());

        if(user.isEmpty()) {
            User newUser = new User();
            newUser.setSenha(passwordEncoder.encode(body.senha()));
            newUser.setEmail(body.email());
            newUser.setNomeCompleto(body.nomeCompleto());
            newUser.setEstado(body.estado());
            newUser.setCidade(body.cidade());
            newUser.setDocumento(body.documento());
            newUser.setServicoOferecido(body.servicoOferecido());
            this.userRepository.save(newUser);

            String token = this.tokenService.generateToken(newUser);
            return ResponseEntity.ok(new ResponseDto(newUser.getEmail(), token));
        }
        return ResponseEntity.badRequest().build();
    }


    // Busca
    @GetMapping
    public ResponseEntity<List<UserDto>> findAll() {
        List<User> users = userService.getAllUser();
        List<UserDto> userDtos = users.stream().map(UserDto::new).toList();
        return ResponseEntity.ok(userDtos);
    }

    // Read
    @GetMapping("/")
    public List<User> getAllUser() {
        return userService.getAllUser();
    }

    // Read com ID
    @GetMapping("/findById/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id) {
        return userService.findById(id)
                .map(user -> ResponseEntity.ok().body(user))
                .orElse(ResponseEntity.notFound().build());
    }

    // Update
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user) {
        return ResponseEntity.ok(userService.updateUser(id, user));
    }

    // Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }


    // Reads personalizadas
    @GetMapping("/{nomeCompleto}/{id}")
    public ResponseEntity<User> showIdAndName(@PathVariable Long id, @PathVariable String nomeCompleto) {
        return userService.idAndName(id, nomeCompleto)
                .map(user -> ResponseEntity.ok().body(user))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/{nomeCompleto}")
    public ResponseEntity<List<User>> findByNome(@PathVariable String nomeCompleto) {
        List<User> users = userService.findByNomeCompleto(nomeCompleto);
        if (users.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(users);
        }
    }
}
