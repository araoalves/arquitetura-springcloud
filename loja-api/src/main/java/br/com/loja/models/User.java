package br.com.loja.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Data
@NoArgsConstructor

public class User {

	private UUID id;

	private String nome;

	private String telefone;

	private String username;

	private String email;

	@JsonIgnore
	private String password;

	@JsonIgnore
	private Set<Role> roles = new HashSet<>();
	
	public User(String nome, String telefone, String username, String email, String password) {
		this.nome = nome;
		this.telefone = telefone;
		this.username = username;
		this.email = email;
		this.password = password;
	}

}
