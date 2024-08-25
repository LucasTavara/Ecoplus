package com.app.ecoplus.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.ecoplus.DTO.LoginRequestDto;
import com.app.ecoplus.DTO.RegisterRequestDto;
import com.app.ecoplus.DTO.ResponseDto;
import com.app.ecoplus.DTO.UserDto;
import com.app.ecoplus.entity.User;
import com.app.ecoplus.mapper.UserMapper;
import com.app.ecoplus.repository.UserRepository;
import com.app.ecoplus.security.TokenService;
import com.app.ecoplus.service.UserService;
import com.app.ecoplus.service.exception.UserNotFoundException;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

	private final UserService userService;
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;
    private final TokenService tokenService;

    //Created
    
    @PostMapping("/login")
    public ResponseEntity<ResponseDto> login(@RequestBody LoginRequestDto body){
        User user = this.userRepository.findByEmail(body.email()).orElseThrow(() -> new UserNotFoundException("User not found"));

        if(passwordEncoder.matches(body.senha(), user.getSenha())) {
            String token = this.tokenService.generateToken(user);
            UserDto userDto = userMapper.toUserDto(user);
            return ResponseEntity.ok(new ResponseDto(userDto.getEmail(), token));
        }
        return ResponseEntity.badRequest().build();
    }
    @PostMapping(value = "/register", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public ResponseEntity<ResponseDto> register(@ModelAttribute RegisterRequestDto body, BindingResult result) {
            // Se houver erros de validação, retorne um erro 400 com detalhes dos erros

        Optional<User> existingUser = this.userRepository.findByEmail(body.email());

        if (existingUser.isEmpty()) {
            User newUser = new User();
            newUser.setSenha(passwordEncoder.encode(body.senha()));
            newUser.setEmail(body.email());
            newUser.setNomeCompleto(body.nomeCompleto());
            newUser.setCidade(body.cidade());
            newUser.setDocumento(body.documento());
            newUser.setServicoOferecido(body.servicoOferecido());
            this.userRepository.save(newUser);

            String token = this.tokenService.generateToken(newUser);

            UserDto userDto = userMapper.toUserDto(newUser);
            return ResponseEntity.ok(new ResponseDto(userDto.getEmail(), token));
        } else {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(new ResponseDto("User already exists", ""));
        }
    }

    // Busca
    @GetMapping
    public ResponseEntity<List<UserDto>> findAll() {
        List<UserDto> userDto = userService.getAllUser();
        return ResponseEntity.ok(userDto);
    }

    // Read
    @GetMapping("/")
    public List<UserDto> getAllUser() {
        return userService.getAllUser();
    }

    // Read com ID
    @GetMapping("/findById/{id}")
    public ResponseEntity<UserDto> findById(@PathVariable Long id) {
        return userService.findById(id)
                .map(user -> ResponseEntity.ok().body(user))
                .orElse(ResponseEntity.notFound().build());
    }

    // Update
    @PutMapping("/{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable Long id, @RequestBody UserDto userDto) {
        return ResponseEntity.ok(userService.updateUser(id, userDto));
    }

    // Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

    // Reads personalizadas
    @GetMapping("/{id}/{nomeCompleto}")
    public ResponseEntity<UserDto> showIdAndName(@PathVariable Long id, @PathVariable String nomeCompleto) {
        return userService.idAndName(id, nomeCompleto)
                .map(user -> ResponseEntity.ok().body(user))
                .orElse(ResponseEntity.notFound().build());
    }
}