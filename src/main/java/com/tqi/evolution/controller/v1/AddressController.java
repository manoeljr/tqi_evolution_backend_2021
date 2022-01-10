package com.tqi.evolution.controller.v1;

import com.tqi.evolution.persistence.model.Address;
import com.tqi.evolution.persistence.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api/v1/address")
public class AddressController {

    @Autowired
    public AddressRepository addressRepository;

    @GetMapping
    public ResponseEntity<List<Address>> findAll() {
        return ResponseEntity.ok(addressRepository.findAll());
    }

}
