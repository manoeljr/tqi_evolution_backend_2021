package com.tqi.evolution.service;

import com.tqi.evolution.config.PasswordEncoder;
import com.tqi.evolution.persistence.model.Address;
import com.tqi.evolution.persistence.model.Client;
import com.tqi.evolution.persistence.model.Credit;
import com.tqi.evolution.persistence.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


@Service
public class ClientService {

    @Autowired
    public ClientRepository clientRepository;
    @Autowired
    public CreditService creditService;
    @Autowired
    public AddressService addressService;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public List<Client> listAll() {
        return clientRepository.findAll();
    }

    public Client findById(Long id) {
        return clientRepository
                .findById(id)
                .orElseThrow(
                        () -> new ResponseStatusException(
                                HttpStatus.NO_CONTENT, "Client not found")
                );
    }

    public List<Client> findByName(String name) {
        return clientRepository.findByName(name);
    }

    public List<Client> findByCpf(String cpf) {
        return clientRepository.findByCpf(cpf);
    }

    public Client add(Client client) {
        PasswordEncoder passwordEncoder = new PasswordEncoder();
        client.setPassword(passwordEncoder.encoderPassword(client.getPassword()));
        return clientRepository.save(client);
    }

    public void delete(Long id) {
        clientRepository.deleteById(id);
    }

    public Client replace(Client client) {
        return clientRepository.saveAndFlush(client);
    }

    public Credit saveCredit(Long clientId, Credit credit) {
        Client client = findById(clientId);
        credit.setClient(client);
        return creditService.addCredit(credit);
    }

    public Address saveAddress(Long clientId, Address address) {
        Client client = findById(clientId);
        address.setClient(client);
        return  addressService.addAddress(address);
    }

    public List<Credit> listCreditClient(Long id) {
        Client client = findById(id);
        return client.getCredits();
    }

}
