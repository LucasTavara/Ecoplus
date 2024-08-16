package com.app.ecoplus.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.ecoplus.entity.User;


@Repository
public interface UserRepository  extends JpaRepository<User, Long> {
}