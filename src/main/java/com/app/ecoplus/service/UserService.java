package com.app.ecoplus.service;
import com.app.ecoplus.entity.User;
import com.app.ecoplus.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    //Uma lista do tipo User que retorna todos os usuários

    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    //Busca um usuário pelo seu id, tendo a possibilidade de haver ou não um valor nulo

    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    //Cria um novo usuário com todas as informações necessárias e salva o mesmo no banco de dados

    public User createUser(User user) {
        return userRepository.save(user);
    }

    /*Verifica se o usuário existe pelo seu id antes de atualizar, se o mesmo existir, as alterações
    serão salvas no banco de dados, senão,o método lança uma exceção com a mensagem de que o usuário
    não foi encontrado.
     */

    public User updateUser(User user) {
    Optional<User> newUser = findById(user.getId());
    User existingUser = null;
    if (newUser.isPresent()) {
        existingUser = newUser.get();
        existingUser.setNome(user.getNome());
        return userRepository.save(existingUser);
    }else {
        throw new RuntimeException("User not found with ID:" + user.getId());
    }

}
}
