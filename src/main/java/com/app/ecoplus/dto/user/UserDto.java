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
	public UserDto(String email, String password, String nomeCompleto, String phone, String age, String endereco, String documento, UserRole role) {
		this.email = email;
		this.password = password;
		this.nomeCompleto = nomeCompleto;
		this.phone = phone;
		this.age = age;
		this.endereco = endereco;
		this.documento = documento;
		this.role = role;
	}
}


