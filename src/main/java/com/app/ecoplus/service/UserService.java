package com.app.ecoplus.service;



import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.app.ecoplus.dto.user.UserDto;
import com.app.ecoplus.entity.user.User;
import com.app.ecoplus.mapper.UserMapper;
import com.app.ecoplus.repository.UserRepository;
import com.app.ecoplus.service.exception.UserNotFoundException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {


    private final UserRepository userRepository;
    private final UserMapper userMapper;
    
    
    

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByLogin(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
        UserDto userDto = userMapper.toUserDto(user);
        return new org.springframework.security.core.userdetails.User(userDto.getLogin(), userDto.getPassword(), new ArrayList<>());
    }
    
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
    public List<UserDto> findAll() {
        List<User> user = userRepository.findAll();
        return user.stream().map(userMapper::toUserDto).toList();
    }
    
    public Optional<UserDto> findById(Long id){
    	Optional<User> user = userRepository.findById(id);
    	if(user.isEmpty()) {
        	return Optional.empty();
    	}
    	User transformUser = user.get();
		return Optional.of(userMapper.toUserDto(transformUser));
     }
  
}