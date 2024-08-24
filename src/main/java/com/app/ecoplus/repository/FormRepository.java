package com.app.ecoplus.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.ecoplus.entity.Form;

import java.util.Optional;


@Repository
public interface FormRepository extends JpaRepository<Form, Long> {

    Optional<Form> findByEmail(String email);
}