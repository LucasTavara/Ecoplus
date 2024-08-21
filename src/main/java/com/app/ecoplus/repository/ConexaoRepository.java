package com.app.ecoplus.repository;

import com.app.ecoplus.entity.Conexao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface ConexaoRepository extends JpaRepository<Conexao, Long> {



}
