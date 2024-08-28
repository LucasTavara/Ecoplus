package com.app.ecoplus.dto.user;

import java.io.Serializable;

import com.app.ecoplus.entity.user.User;
import com.app.ecoplus.entity.user.UserRole;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto implements Serializable{

	private static final long serialVersionUID = 1L;
	private Long id;
	
    private String login;
    private String email;
    private String password;
    
    private String nomeCompleto;
    private String cidade;
    private String servicoOferecido;
    private String documento;
    private UserRole role;
    
    
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
        this.login = user.getLogin();
        this.password = user.getPassword();
        this.email = user.getEmail();
        this.nomeCompleto = user.getNomeCompleto();
        this.cidade = user.getCidade();
        this.servicoOferecido = user.getServicoOferecido();
        this.documento = user.getDocumento();
        this.role = user.getRole();
    }
    
	public UserDto(String login, String password, String email, String nomeCompleto, String cidade, String servicoOferecido,
			 String documento, UserRole role) {
		this.login = login;
		this.password = password;
		this.email = email;
		this.nomeCompleto = nomeCompleto;
		this.cidade = cidade;
		this.servicoOferecido = servicoOferecido;
		this.documento = documento;
		this.role = role;
	}
}


