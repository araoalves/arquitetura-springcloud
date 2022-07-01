package br.com.fornecedor.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Data
@NoArgsConstructor

public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;

	private String nome;

	private String telefone;

	private String username;

	private String email;

	private String password;

	private Set<Role> roles = new HashSet<>();
	
	public User(String nome, String telefone, String username, String email, String password) {
		this.nome = nome;
		this.telefone = telefone;
		this.username = username;
		this.email = email;
		this.password = password;
	}

}
