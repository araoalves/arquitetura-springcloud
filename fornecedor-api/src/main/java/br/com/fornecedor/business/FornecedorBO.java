package br.com.fornecedor.business;

import br.com.fornecedor.models.Fornecedor;
import br.com.fornecedor.repository.FornecedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class FornecedorBO {

    @Autowired
    private FornecedorRepository fornecedorRepository;

    public Fornecedor save(Fornecedor fornecedor) {
        return fornecedorRepository.save(fornecedor);
    }

    public Fornecedor findById(UUID id) {
        return fornecedorRepository.findById(id).get();
    }
}
