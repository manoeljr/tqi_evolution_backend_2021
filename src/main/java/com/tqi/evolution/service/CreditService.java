package com.tqi.evolution.service;

import com.tqi.evolution.persistence.model.Credit;
import com.tqi.evolution.persistence.repository.CreditRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;


@Service
public class CreditService {

    @Autowired
    private CreditRepository creditRepository;
    private final static Integer DATE_CREDIT_MAX = 60;
    private final static Integer DATE_CREDIT_INICIO = 1;
    private LocalDate LIMITE = LocalDate.now(ZoneId.of("UTC")).plusMonths(3);


    public CreditService(CreditRepository creditRepository) {
        this.creditRepository = creditRepository;
    }

    public List<Credit> all() {
        return creditRepository.findAll();
    }

    public Credit findByCreditId(Long id) {
        return creditRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NO_CONTENT, "Credit not found"));
    }

    public List<Credit> detailCredit(Long id) {
        return creditRepository.findAllCreditAndClient(id);
    }

    public Credit addCredit(Credit credit) {
        if ((credit.getDateFirstParCredit().isBefore(LIMITE)) || (credit.getDateFirstParCredit().isEqual(LIMITE))) {
            if ((credit.getQuantityParCredit()<=DATE_CREDIT_MAX) && (credit.getQuantityParCredit()>DATE_CREDIT_INICIO)){
                creditRepository.save(credit);
            }
        }
        return credit;
    }

}
