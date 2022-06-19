package br.com.loja.models;

import lombok.Data;
import java.util.UUID;

@Data
public class Fornecedor {
    private UUID id;
    private String nome;
}
