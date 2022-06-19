package br.com.loja.clients;

import br.com.loja.models.Fornecedor;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.UUID;

@FeignClient(name = "fornecedor")
public interface FornecedorClient {

    @RequestMapping(value = "fornecedor/{id}", method = RequestMethod.GET)
    public Fornecedor findById(@PathVariable("id") UUID id);
}
