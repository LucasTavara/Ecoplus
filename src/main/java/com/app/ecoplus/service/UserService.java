package com.app.ecoplus.service;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.app.ecoplus.DTO.UserDto;
import com.app.ecoplus.entity.User;
import com.app.ecoplus.repository.UserRepository;
import com.app.ecoplus.util.UserMapper;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public UserDto createUser(UserDto userDto) {
        User user = userMapper.toEntity(userDto);
        User savedUser = userRepository.save(user);
        return userMapper.toDto(savedUser);
    }

    public UserDto updateUser(Long id, UserDto userDto) {
        if (userRepository.existsById(id)) {
            User user = userMapper.toEntity(userDto);
            user.setId(id);  // Ensure the ID is set for updating
            User updatedUser = userRepository.save(user);
            return userMapper.toDto(updatedUser);
        } else {
            throw new RuntimeException("User not found");
        }
    }
    
    // Checar aqui futuramente para melhores implementações

    public void deleteUser(Long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
        } else {
            throw new RuntimeException("User not found");
        }
    }

    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    public Optional<UserDto> findById(Long id) {
        return userRepository.findById(id).map(userMapper::toDto);
    }

    public List<User> findByNomeCompleto(String nomeCompleto) {
        return userRepository.findByNomeCompleto(nomeCompleto);
    }

    public Optional<User> getEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public List<User> getCidade(String cidade) {
        return userRepository.findByCidade(cidade);
    }

    public List<User> getDocumento(String documento) {
        return userRepository.findByDocumento(documento);
    }

    public List<User> findByServicoFornecido(String servicoFornecido) {
        return userRepository.findByServicoOferecido(servicoFornecido);
    }

    public Optional<UserDto> idAndName(Long id, String nomeCompleto) {
        return userRepository.findById(id)
            .filter(user -> user.getNomeCompleto().equals(nomeCompleto))
            .map(userMapper::toDto);
    }
}
