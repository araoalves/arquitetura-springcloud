package br.com.authentication.model.reponse;

import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class JwtResponse {
	private String token;
	private String type = "Bearer";
	private UUID id;
	private String username;
	private String email;
	private List<String> roles;
	private String nome;

	public JwtResponse(String accessToken, UUID id, String username, String email, List<String> roles, String nome) {
		this.token = accessToken;
		this.id = id;
		this.username = username;
		this.email = email;
		this.roles = roles;
		this.nome = nome;
	}
}
