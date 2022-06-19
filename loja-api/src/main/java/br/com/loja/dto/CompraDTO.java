package br.com.loja.dto;

import br.com.loja.models.Fornecedor;
import lombok.Data;

import java.util.List;

@Data
public class CompraDTO {
    private List<ItensDTO> itens;
    private EnderecoDTO endereco;
    private Fornecedor fornecedor;
}
