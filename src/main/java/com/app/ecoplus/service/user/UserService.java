package com.app.ecoplus.service.user;


import com.app.ecoplus.dto.user.UserDto;
import com.app.ecoplus.entity.user.User;
import com.app.ecoplus.mapper.UserMapper;
import com.app.ecoplus.repository.UserRepository;
import com.app.ecoplus.service.exception.ObjectNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {


    private final UserRepository userRepository;
    private final UserMapper userMapper;
    
    
    

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByEmail(username);
        if (user.isEmpty()) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
        UserDto userDto = userMapper.toUserDto(user.get());
        return new org.springframework.security.core.userdetails.User(userDto.getEmail(), userDto.getPassword(), new ArrayList<>());
    }
    
    //Criar
    public UserDto createUser(UserDto userDto) {
    	User user = userMapper.toUser(userDto);
        User savedUser = userRepository.save(user);
        return userMapper.toUserDto(savedUser);
    }

    //Atualizar
    public UserDto updateUser(Long id, UserDto userDto) {
        Optional<User> existingUser = userRepository.findById(id);
        if(existingUser.isEmpty()){
            throw new ObjectNotFoundException("Order not found");
        }
        User user = existingUser.get();
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setNomeCompleto(userDto.getNomeCompleto());
        user.setPhone(userDto.getPhone());
        user.setAge(userDto.getAge());
        user.setEndereco(userDto.getEndereco());
        user.setDocumento(userDto.getDocumento());
        user.setRole(userDto.getRole());

        User updatedUser = userRepository.save(user);
        return userMapper.toUserDto(updatedUser);
    }

    //Deletar
    public void deleteUser(Long id) {
        try{
            userRepository.deleteById(id);
        }catch(Exception e){
            throw new ObjectNotFoundException("Teste");
        }


//        Optional<User> user = userRepository.findById(id);
//        if (user.isEmpty()) {
//            userRepository.deleteById(id);
//        } else {
//            throw new ObjectNotFoundException("User not found");
//        }
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

//    Refinar depois.
    public Optional<UserDto> findByEmail(String email){
        Optional <User> user = userRepository.findByEmail(email);
        return user.map(userMapper::toUserDto);
    }

}