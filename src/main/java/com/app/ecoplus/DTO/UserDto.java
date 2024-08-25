package com.app.ecoplus.DTO;

import java.io.Serializable;

import com.app.ecoplus.entity.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto implements Serializable{

	private static final long serialVersionUID = 1L;
	private Long id;
    private String nomeCompleto;
    private String senha;
    private String email;
    private String cidade;
    private String servicoOferecido;
    private Integer documento;
    
    
	/*
	 * Construtor que recebe User entity. Necessário para transfêrencia de objetos.
	 * 
	 * A Annotation @AllArgsConstructor gera um
	 * construtor com cada field declarado na classe, para poupar tempo poderia ser
	 * feito um field de 'User'. Porém, quando o @AllArgsConstrutor cria o construtor,
	 * além dele definir o parâmetro, ele faz uma referência ao mesmo, 'this.user = user', 
	 * logo, não seria o ideal refenciar o User visto que todo o propósito do DTO seria perdido.
	 * 
	 * É necessário declarar todas as propriedades do paramêtro no construtor para o stream().map()
	 * na classe Controller funcionar corretamente, pois, para transformar objetos de uma classe para
	 * a outra, você tem que fazer eles serem inicializados naquela classe. 
	 * 
	 * ~Ed
	 */
    
    public UserDto(User user) {
        this.id = user.getId();
        this.nomeCompleto = user.getNomeCompleto();
        this.senha = user.getSenha();
        this.email = user.getEmail();
        this.cidade = user.getCidade();
        this.servicoOferecido = user.getServicoOferecido();
        this.documento = user.getDocumento();
    }
    
    public User transformaParaObjeto() {
        return
                new User(null,nomeCompleto,senha,email,cidade,servicoOferecido,documento);
    }
}


