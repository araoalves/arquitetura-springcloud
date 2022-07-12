package br.com.fornecedor.controllers;

import br.com.fornecedor.business.FornecedorBO;
import br.com.fornecedor.models.Fornecedor;
import br.com.fornecedor.publishers.FornecedorEventPublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/")
public class FornecedorController {

    @Autowired
    private FornecedorBO fornecedorBO;

    @Autowired
    private FornecedorEventPublisher fornecedorEventPublisher;

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<?> create(@RequestBody Fornecedor fornecedor) throws Exception {
        try {
            Fornecedor fornecedorCreat = fornecedorBO.save(fornecedor);
            fornecedorEventPublisher.publishFornecedorEvent(fornecedorCreat);
            return new ResponseEntity<>(fornecedorCreat, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Fornecedor> findById(@PathVariable("id") UUID id) {
        try {
            return new ResponseEntity<>(fornecedorBO.findById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

}
