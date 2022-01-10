package com.tqi.evolution.controller.v1;

import com.tqi.evolution.persistence.model.Address;
import com.tqi.evolution.persistence.model.Client;
import com.tqi.evolution.persistence.model.Credit;
import com.tqi.evolution.service.ClientService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/api/v1/clients")
public class ClientController {

    @Autowired
    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    /**
     * Listando todos clientes
     * @return
     */
    @GetMapping
    @ApiOperation(value = "Retorna uma lista de clientes")
    public ResponseEntity<List<Client>> findAll() {
        return ResponseEntity.ok(clientService.listAll());
    }

    /**
     * Buscando um cliente por ID
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    @ApiOperation(value = "Retorna um cliente por ID")
    public ResponseEntity<Client> findById(@PathVariable Long id) {
        return ResponseEntity.ok(clientService.findById(id));
    }

    /**
     * Buscando um cliente por NOME
     * @param name
     * @return
     */
    @GetMapping("/name/{name}")
    @ApiOperation(value = "Retorna um cliente pelo NOME")
    public ResponseEntity<List<Client>> findByName(@PathVariable String name) {
        return ResponseEntity.ok(clientService.findByName(name));
    }

    /**
     * Buscando um cliente por CPF
     * @param cpf
     * @return
     */
    @GetMapping("/cpf/{cpf}")
    @ApiOperation(value = "Retorna um cliente pelo CPF")
    public ResponseEntity<List<Client>> findByCpf(@PathVariable String cpf) {
        return ResponseEntity.ok(clientService.findByCpf(cpf));
    }

    /**
     * Deletando um cliente
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    @ApiOperation(value = "Deleta um cliente por ID")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        clientService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /**
     * Editando um cliente
     * @param client
     * @return
     */
    @PutMapping
    @ApiOperation(value = "Atualiza as informações de um cliente")
    public ResponseEntity<Client> replace(@Valid @RequestBody Client client) {
        return new ResponseEntity<>(clientService.replace(client), HttpStatus.NO_CONTENT);
    }

    /**
     * Salvando um cliente
     * @param client
     * @return
     */
    @PostMapping
    @ApiOperation(value = "Adiciona um cliente")
    public ResponseEntity<Client> save(@Valid @RequestBody Client client) {
        return new ResponseEntity<>(clientService.add(client), HttpStatus.CREATED);
    }

    /**
     * Cadastrando endereço em um determinado cliente
     * @param id
     * @param address
     * @return
     */
    @PostMapping("/{id}/address")
    @ApiOperation(value = "Adiciona um endereço em um determinado cliente")
    public ResponseEntity<Void> addAddress(@PathVariable Long id, @RequestBody Address address) {
        clientService.saveAddress(id, address);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    /**
     * Cadastrando emprestimo em um determinado cliente
     * @param id
     * @param credit
     * @return
     */
    @PostMapping("/{id}/credits")
    @ApiOperation(value = "Adiciona um EMPRESTIMO em um determinado cliente")
    public ResponseEntity<Void> addCredit(@Valid @PathVariable Long id, @RequestBody Credit credit) {
        clientService.saveCredit(id, credit);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    /**
     * Buscando todos os emprestimos de um determinado cliente
     * @param id
     * @return
     */
    @GetMapping("/{id}/credits")
    @ApiOperation(value = "Retorna uma lista de EMPRESTIMOS de um determinado cliente")
    public ResponseEntity<List<Credit>> clientFindAllCredit(@PathVariable Long id) {
        return ResponseEntity.ok(clientService.listCreditClient(id));
    }

}
