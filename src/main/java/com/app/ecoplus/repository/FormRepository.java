package com.app.ecoplus.repository;

import com.app.ecoplus.entity.Form;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface FormRepository extends JpaRepository<Form, Long> {

    Optional<Form> findByEmail(String email);

    Optional<Form> findById(Long id);
}