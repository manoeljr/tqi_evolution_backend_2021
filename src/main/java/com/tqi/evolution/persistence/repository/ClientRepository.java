package com.tqi.evolution.persistence.repository;

import com.tqi.evolution.persistence.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
    List<Client> findByName(String name);
    List<Client> findByCpf(String cpf);
    Client findByEmail(String email);
}
