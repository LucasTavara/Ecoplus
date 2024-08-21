package com.app.ecoplus.repository;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.ecoplus.entity.User;


@Repository
public interface UserRepository  extends JpaRepository<User, Long> {
	
	// Checar depois.
	Optional<User> findByNomeCompleto(String nomeCompleto);


    Optional<User> findByEmail(String email);
    boolean existsByEmail(String email);
    

}
