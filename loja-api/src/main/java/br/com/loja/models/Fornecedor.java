package br.com.loja.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Fornecedor {
    private UUID id;
    private String nome;
    private String email;
    private String celular;
    private String cpfCnpj;
}
