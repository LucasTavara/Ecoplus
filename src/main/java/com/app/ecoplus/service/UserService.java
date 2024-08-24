package com.app.ecoplus.service;


import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.app.ecoplus.entity.User;
import com.app.ecoplus.repository.UserRepository;

@Service
public class UserService {


    private final UserRepository userRepository;

    private UserService(UserRepository userRepository) {
    	this.userRepository = userRepository;
    }

    //Criar
    public User createUser(User user) {
        return userRepository.save(user);
    }

    //Atualizar
    public User updateUser(Long id, User user) {
        if (userRepository.existsById(id)) {
        	user.setId(id);
            return userRepository.save(user);
        } else {
            throw new RuntimeException("User not found");
        }
    }

    //Deletar
    public void deleteUser(Long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
        } else {
            throw new RuntimeException("User not found");
        }
    }
    // Listar
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }
    public List<User> findByNomeCompleto(String nomeCompleto){
    	return userRepository.findByNomeCompleto(nomeCompleto);
    }

    public List<User> findByServicoFornecido(String servicoFornecido){
    	return userRepository.findByServicoOferecido(servicoFornecido);
    }

    public Optional<User> idAndName(Long id, String nomeCompleto){
    	   Optional<User> user = userRepository.findById(id);

    	    if (user.isPresent() && user.get().getNomeCompleto().equals(nomeCompleto)) {
    	        return user;
    	    }
    	    else {
    	    	return Optional.empty();
    	    }

    }
}