package com.app.ecoplus.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.ecoplus.entity.Fornecedor;

@Repository
public interface FornecedorRepository extends JpaRepository<Fornecedor, Long> {

    @Override
	Optional<Fornecedor> findById(Long id);

    List<Fornecedor> findByCidade(String cidade);

    List<Fornecedor> findByServicoOferecido(String servicoOferecido);

    Optional<Fornecedor> findByEmail(String email);

    List<Fornecedor> findByNomeCompleto(String nomeCompleto);

    List<Fornecedor> findByDocumento(Integer documento);
}
