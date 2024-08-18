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

    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    //Checks if user exists before updating

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