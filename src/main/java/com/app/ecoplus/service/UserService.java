package com.app.ecoplus.service;


import com.app.ecoplus.DTO.UserDto;

import com.app.ecoplus.entity.User;
import com.app.ecoplus.repository.UserRepository;
import com.app.ecoplus.service.Exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    //Uma lista do tipo User que retorna todos os usuários
    public List<User> salvar() {return userRepository.findAll();}


    //Busca por Id a Conexão estabelecida
    public User findById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Conexao not found with id: " + id));
    }

    // Criação um novo usuário com todas as informações necessárias e salvar o mesmo no banco de dados
    public User created(User user) {return userRepository.save(user);}

    //Update
    public ResponseEntity<?> updateUser(Long id, UserDto userDto) {
        var conexaoEntityOptional = userRepository.findById(id);

        if (conexaoEntityOptional.isPresent()) {
            var user = conexaoEntityOptional.get();

            if (userDto.getNomeCompleto() != null) {
                user.setNomeCompleto(userDto.getNomeCompleto());
            }
            if (userDto.getEmail() != null) {
                user.setEmail(userDto.getEmail());
            }
            if (userDto.getCidade() != null) {
                user.setCidade(userDto.getCidade());
            }
            if (userDto.getServiçoOferecido() != null) {
                user.setServiçoOferecido(userDto.getServiçoOferecido());
            }
            if (userDto.getDocumento() != null) {
                user.setDocumento(userDto.getDocumento());
            }

            userRepository.save(user);
            return ResponseEntity.ok("Conexão atualizada com sucesso");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Conexão não encontrada");
        }
    }

    //Delete
    public User deleteUser(Long id) {userRepository.deleteById(id);
        return findById(id);
    }

}
