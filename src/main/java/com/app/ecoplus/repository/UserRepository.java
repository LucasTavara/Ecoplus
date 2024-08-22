package com.app.ecoplus.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.ecoplus.entity.User;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	Optional <User> findById(Long Id);
	
	List<User> findByCidade(String Cidade);
	
	List<User> findByServicoOferecido(String servicoOferecido);
	
    Optional<User> findByEmail(String email);

    List<User> findByNomeCompleto(String nomeCompleto);
    
    List<User> findByDocumento(String documento);


}
