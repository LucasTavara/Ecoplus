package com.app.ecoplus.service;



import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.app.ecoplus.DTO.UserDto;
import com.app.ecoplus.entity.User;
import com.app.ecoplus.mapper.UserMapper;
import com.app.ecoplus.repository.UserRepository;
import com.app.ecoplus.service.exception.UserNotFoundException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {


    private final UserRepository userRepository;
    private final UserMapper userMapper;

    //Criar
    public UserDto createUser(UserDto userDto) {
    	User user = userMapper.toUser(userDto);
        User savedUser = userRepository.save(user);
        return userMapper.toUserDto(savedUser);
    }

    //Atualizar
    public UserDto updateUser(Long id, UserDto userDto) {
        if (userRepository.existsById(id)) {
        	
        	User updatedUser = userMapper.toUser(userDto);
        	updatedUser.setId(id);
        	User savedUser = userRepository.save(updatedUser);
        	
        	
            return userMapper.toUserDto(savedUser);
        } else {
            throw new UserNotFoundException("User not found");
        }
    }

    //Deletar
    public void deleteUser(Long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
        } else {
            throw new UserNotFoundException("User not found");
        }
    }
    // Listar
    public List<UserDto> getAllUser() {
        List<User> user = userRepository.findAll();
        return user.stream().map(userMapper::toUserDto).toList();
    }

    
    // Precisa de Condicional. -Ed
    public Optional<UserDto> findById(Long id) {
    	Optional<User> user = userRepository.findById(id); 
    	UserDto userDto = userMapper.toUserDto(user.get());
    	return Optional.of(userDto);
    	
    }
    // Precisa de Condicional. -Ed
    public List<UserDto> findByNomeCompleto(String nomeCompleto){
    	List<User> user = userRepository.findByNomeCompleto(nomeCompleto);
    	return user.stream().map(userMapper::toUserDto).toList();
    }

    public List<UserDto> findByServicoFornecido(String servicoFornecido){
    	List<User> user = userRepository.findByServicoOferecido(servicoFornecido);
    	return  user.stream().map(userMapper::toUserDto).toList();
    }

    public Optional<UserDto> idAndName(Long id, String nomeCompleto){
	   	Optional<User>user = userRepository.findById(id);

	    if (user.isPresent() && user.get().getNomeCompleto().equals(nomeCompleto)) {
	    	UserDto userDto = userMapper.toUserDto(user.get());
	        return Optional.of(userDto);
	    }
	    else {
	    	return Optional.empty();
	    }

    }
}