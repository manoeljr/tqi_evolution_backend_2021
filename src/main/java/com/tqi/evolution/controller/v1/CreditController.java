package com.tqi.evolution.controller.v1;

import com.tqi.evolution.persistence.model.Credit;
import com.tqi.evolution.service.CreditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/credits")
public class CreditController {

    @Autowired
    private final CreditService creditService;

    public CreditController(CreditService creditService) {
        this.creditService = creditService;
    }

    @GetMapping
    public ResponseEntity<List<Credit>> findAll() {
        return ResponseEntity.ok(creditService.all());
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<Credit>> detailCredit(@PathVariable Long id) {
        return new ResponseEntity<>(creditService.detailCredit(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Credit> addCredit(@RequestBody Credit credit) {
        return  new ResponseEntity<>(creditService.addCredit(credit), HttpStatus.CREATED);
    }

}
