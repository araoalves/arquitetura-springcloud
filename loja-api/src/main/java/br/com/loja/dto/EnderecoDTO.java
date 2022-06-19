package br.com.loja.dto;

import lombok.Data;

@Data
public class EnderecoDTO {
    private String rua;
    private int numero;
    private String cep;
    private String estado;
}
