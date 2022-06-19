package br.com.fornecedor.repository;

import br.com.fornecedor.models.Fornecedor;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface FornecedorRepository  extends CrudRepository<Fornecedor, UUID> {
}
