package br.com.loja.dto;

import br.com.loja.models.Fornecedor;
import br.com.loja.models.User;
import lombok.Data;

import java.util.List;

@Data
public class CompraDTO {
    private List<ItensDTO> itens;
    private EnderecoDTO endereco;
    private Fornecedor fornecedor;
    private User cliente;
}
