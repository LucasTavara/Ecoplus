package com.app.ecoplus.controller.user;

import com.app.ecoplus.dto.ResponseDto;
import com.app.ecoplus.dto.user.UserAuthDto;
import com.app.ecoplus.dto.user.UserDto;
import com.app.ecoplus.dto.user.UserRegisterAuthDto;
import com.app.ecoplus.mapper.UserMapper;
import com.app.ecoplus.security.TokenService;
import com.app.ecoplus.service.user.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("auth")
@RequiredArgsConstructor
public class UserAuthController {

	private final TokenService tokenService;
	private final AuthenticationManager authenticationManager;
	private final UserService userService;
	private final UserMapper userMapper;
	
	@PostMapping(value= "/login")
	public ResponseEntity<ResponseDto> login(@RequestBody @Valid UserAuthDto userAuthDto) {
	    try {
	        var usernamePassword = new UsernamePasswordAuthenticationToken(userAuthDto.email(), userAuthDto.password());
			var authentication = authenticationManager.authenticate(usernamePassword);

			String username = authentication.getName();
			String token = tokenService.generateToken(authentication);

			ResponseDto responseDto = new ResponseDto(username, token);
	        return ResponseEntity.ok(responseDto);
	    } catch (AuthenticationException e) {
	        return ResponseEntity.status(403).build();
	    }
	}
	
	@PostMapping(value="/register")
	public ResponseEntity<?> register(@RequestBody @Valid UserRegisterAuthDto registerDto) {
        if(this.userService.findByEmail(registerDto.email()).isPresent()) {
        	return ResponseEntity.badRequest().build();
        }
		String encryptedPassword = new BCryptPasswordEncoder().encode(registerDto.password());
		UserDto newUser = new UserDto(
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

	//Tratariva de erro BAD_REQUEST na requisição
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
		Map<String, String> Errors = new HashMap<>();

		ex.getBindingResult().getAllErrors().forEach(error -> {
			String fieldName = ((FieldError) error).getField();
			String errorMessage = error.getDefaultMessage();
			Errors.put(fieldName, errorMessage);
		});
		return Errors;
	}
}

