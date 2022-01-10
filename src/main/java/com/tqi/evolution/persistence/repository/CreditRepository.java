package com.tqi.evolution.persistence.repository;

import com.tqi.evolution.persistence.model.Credit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CreditRepository extends JpaRepository<Credit, Long> {

    @Query(value = "SELECT * FROM client INNER JOIN credit ON client.id = credit.client_id", nativeQuery = true)
    List<Credit> findAllCreditAndClient(Long id);

}
