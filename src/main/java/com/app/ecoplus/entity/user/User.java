package com.app.ecoplus.entity.user;

import com.app.ecoplus.entity.Order.Order;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "Users")
@Data
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class User implements UserDetails {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;

	@Column(name = "email", nullable = false, unique = true)
	private String email;

	@Column(name = "password", nullable = false)
	private String password;

	@Column(name = "NomeCompleto")
	private String nomeCompleto;

	@Column(name = "Phone")
	private String phone;

	@Column(name = "Age")
	private String age;

	@Column(name = "Endereço")
	private String endereco;

	@Column(name = "Documento", unique = true)
	private String documento;

	@Column(name="UserType")
	private UserType type;

	@OneToMany(mappedBy = "user_id")
	private List<Order> order;

	//	Admin e User.
	@Column(name = "Roles")
	private UserRole role;

	public User(String email, String password, String nomeCompleto, String phone, String age, String endereco, String documento, UserRole role) {
		this.email = email;
		this.password = password;
		this.nomeCompleto = nomeCompleto;
		this.phone = phone;
		this.age = age;
		this.endereco = endereco;
		this.documento = documento;
		this.role = role;
	}



	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		if (this.role == UserRole.ADMIN)
			return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"), new SimpleGrantedAuthority("ROLE_USER"));
		else
			return List.of(new SimpleGrantedAuthority("ROLE_USER"));
	}

	@Override
	public String getUsername() {
		return email;
	}
}
