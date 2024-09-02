package com.app.ecoplus.controller.user;

import com.app.ecoplus.service.user.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.ecoplus.dto.user.UserAuthDto;
import com.app.ecoplus.dto.user.UserRegisterAuthDto;
import com.app.ecoplus.entity.user.User;
import com.app.ecoplus.repository.UserRepository;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("auth")
@RequiredArgsConstructor
public class UserAuthController {

	private final AuthenticationManager authenticationManager;
	private final UserRepository userRepository;
	private final UserService userService;
	
	@PostMapping(value= "/login")
	public ResponseEntity<String> login(@RequestBody @Valid UserAuthDto userAuthDto) {
	    try {
	        var usernamePassword = new UsernamePasswordAuthenticationToken(userAuthDto.email(), userAuthDto.password());
	        authenticationManager.authenticate(usernamePassword);
	        return ResponseEntity.ok().build();
	    } catch (AuthenticationException e) {
	        return ResponseEntity.status(403).body("Autenticação falhou, usuário ou senha inválido.");
	    }
	}
	
	@PostMapping(value="/register")
	public ResponseEntity<?> register(@RequestBody @Valid UserRegisterAuthDto registerDto) {
        if(this.userService.findByEmail(registerDto.email()).isPresent()) {
        	return ResponseEntity.badRequest().build();
        }
		String encryptedPassword = new BCryptPasswordEncoder().encode(registerDto.password());
		User newUser = new User(
				registerDto.email(),
				encryptedPassword,
				registerDto.nomeCompleto(),
				registerDto.phone(),
				registerDto.age(),
				registerDto.endereco(),
				registerDto.documento(),
				registerDto.role());
		this.userService.createUser(newUser);
		return ResponseEntity.ok().build();
	}
}

