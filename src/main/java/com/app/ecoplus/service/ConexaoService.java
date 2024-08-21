package com.app.ecoplus.service;


import com.app.ecoplus.DTO.ConexaoDto;
import com.app.ecoplus.entity.Conexao;
import com.app.ecoplus.repository.ConexaoRepository;
import com.app.ecoplus.service.Exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class ConexaoService {

    @Autowired
    private ConexaoRepository conexaoRepository;


    //Uma lista do tipo User que retorna todos os usuários
    public List<Conexao> findAll() {return conexaoRepository.findAll();}


    //Busca por Id a Conexão estabelecida
    public Conexao findById(Long id) {
        return conexaoRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Conexao not found with id: " + id));
    }

    // Criação um novo usuário com todas as informações necessárias e salvar o mesmo no banco de dados
    public Conexao created(Conexao conexao) {return conexaoRepository.save(conexao);}

    //Update
    public ResponseEntity<?> updateConexao(Long id, ConexaoDto conexaoDto) {
        var conexaoEntityOptional = conexaoRepository.findById(id);

        if (conexaoEntityOptional.isPresent()) {
            var conexao = conexaoEntityOptional.get();

            if (conexaoDto.getNome() != null) {
                conexao.setNome(conexaoDto.getNome());
            }
            if (conexaoDto.getEmail() != null) {
                conexao.setEmail(conexaoDto.getEmail());
            }
            if (conexaoDto.getCidade() != null) {
                conexao.setCidade(conexaoDto.getCidade());
            }
            if (conexaoDto.getEmpresa() != null) {
                conexao.setEmpresa(conexaoDto.getEmpresa());
            }
            if (conexaoDto.getMensagem() != null) {
                conexao.setMensagem(conexaoDto.getMensagem());
            }

            conexaoRepository.save(conexao);
            return ResponseEntity.ok("Conexão atualizada com sucesso");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Conexão não encontrada");
        }
    }

    //Delete
    public Conexao delete(Long id) {conexaoRepository.deleteById(id);
        return findById(id);
    }

}
