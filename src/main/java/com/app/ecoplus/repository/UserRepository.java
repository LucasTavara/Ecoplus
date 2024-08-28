package com.app.ecoplus.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.ecoplus.entity.user.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	
	Optional <User> findById(Long id);

	Optional<User> findByEmail(String email);
	
	User findByLogin(String login);
	
	
    
}
