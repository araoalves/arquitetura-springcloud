package br.com.loja.controller;

import br.com.loja.clients.AuthenticationClient;
import br.com.loja.clients.FornecedorClient;
import br.com.loja.dto.CompraDTO;
import br.com.loja.models.Fornecedor;
import br.com.loja.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/compra")
public class CompraController {

    @Autowired
    private FornecedorClient fornecedorClient;

    @Autowired
    private AuthenticationClient authenticationClient;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> realizarPedido(@RequestBody CompraDTO compraDTO){
        Fornecedor fornecedor = fornecedorClient.findById(compraDTO.getFornecedor().getId());
        User user = authenticationClient.getUser();
        compraDTO.setFornecedor(fornecedor);
        compraDTO.setCliente(user);
        return new ResponseEntity<>(compraDTO, HttpStatus.OK);
    }

}
