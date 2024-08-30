package com.app.ecoplus.entity.user;

import java.util.Collection;
import java.util.List;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

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

	@Column(name = "login", nullable = false, unique = true)
	private String login;

	@Column(name = "password", nullable = false)
	private String password;

	@Column(name = "email", nullable = false, unique = true)
	private String email;

	@Column(name = "nomeCompleto")
	private String nomeCompleto;

	@Column(name = "cidade")
	private String cidade;

	@Column(name = "servicoOferecido")
	private String servicoOferecido;

	@Column(name = "documento", unique = true)
	private String documento;


	@Column(name = "role")
	private UserRole role;

	public User(String login, String password, String email, String nomeCompleto, String cidade, String servicoOferecido,
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

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		if (this.role == UserRole.ADMIN)
			return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"), new SimpleGrantedAuthority("ROLE_USER"));
		else
			return List.of(new SimpleGrantedAuthority("ROLE_USER"));
	}

	@Override
	public String getUsername() {
		return login;
	}
}
