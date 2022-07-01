package br.com.fornecedor.models;

import br.com.fornecedor.enums.ERole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Role {

	private UUID id;
	private ERole name;
}