package com.app.ecoplus.controller.user;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.ecoplus.dto.user.UserDto;
import com.app.ecoplus.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("users")
@RequiredArgsConstructor
public class UserController {

	private final UserService userService;

    // Busca
    @GetMapping("/")
    public ResponseEntity<List<UserDto>> findAll() {
        List<UserDto> userDto = userService.findAll();
        return ResponseEntity.ok(userDto);
    }

    // Read com ID
    @GetMapping("/{id}")
    public ResponseEntity<UserDto> findById(@PathVariable Long id) {
    	Optional<UserDto> userDto = userService.findById(id);
    	if(userDto.isEmpty()) {
    		return ResponseEntity.notFound().build();
    	}
    	return ResponseEntity.ok(userDto.get());
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

}