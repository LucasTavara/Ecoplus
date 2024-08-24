package com.app.ecoplus.repository;


import java.util.List;
import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.ecoplus.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	@Override
	Optional <User> findById(Long id);

	Optional <User> findByEmail(String email);

	List<User> findByServicoOferecido(String servicoOferecido);

    List<User> findByNomeCompleto(String nomeCompleto);



}
