package br.com.loja.dto;

import lombok.Data;

@Data
public class ItensDTO {
    private String descricao;
    private Integer quantidade;
    private Double valor;
}
