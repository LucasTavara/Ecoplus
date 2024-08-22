package com.app.ecoplus.repository;

import com.app.ecoplus.entity.Fornecedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FornecedorRepository extends JpaRepository<Fornecedor, Long> {

    Optional<Fornecedor> findById(Long Id);

    List<Fornecedor> findByCidade(String Cidade);

    List<Fornecedor> findByServicoOferecido(String servicoOferecido);

    Optional<Fornecedor> findByEmail(String email);

    List<Fornecedor> findByNomeCompleto(String nomeCompleto);

    List<Fornecedor> findByDocumento(String documento);
}
