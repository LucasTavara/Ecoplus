package com.app.ecoplus.dto.user;

import com.app.ecoplus.entity.Order.Order;
import com.app.ecoplus.entity.user.User;
import com.app.ecoplus.entity.user.UserRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto implements Serializable{

	private static final long serialVersionUID = 1L;
	private Long id;
	private String email;
	private String password;
	private String nomeCompleto;
	private String phone;
	private String age;
	private String endereco;
	private String documento;
	//	UserType
	private UserRole role;
    //Order
	private List<Order> order;
    
    
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
		this.email = user.getEmail();
		this.password = user.getPassword();
		this.nomeCompleto = user.getNomeCompleto();
		this.phone = user.getPhone();
		this.age = user.getAge();
		this.endereco = user.getEndereco();
		this.documento = user.getDocumento();
		this.role = user.getRole();
	}
}


