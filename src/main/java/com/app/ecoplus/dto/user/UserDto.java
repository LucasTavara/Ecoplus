package com.app.ecoplus.dto.user;

import com.app.ecoplus.entity.Order.Order;
import com.app.ecoplus.entity.user.User;
import com.app.ecoplus.entity.user.UserRole;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
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

	@Valid
	@NotNull(message = "put email")
	private String email;

	@NotNull(message = "put password")
	private String password;

	@NotNull(message = "put name")
	private String nomeCompleto;

	@NotNull(message = "put phone")
	private String phone;

	@NotNull(message = "put age")
	private String age;

	@NotNull(message = "put address")
	private String endereco;

	@NotNull(message = "Put document")
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


