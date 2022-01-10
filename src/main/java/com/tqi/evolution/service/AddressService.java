package com.tqi.evolution.service;

import com.tqi.evolution.persistence.model.Address;
import com.tqi.evolution.persistence.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AddressService {

    @Autowired
    public AddressRepository addressRepository;


    public List<Address> findAll() {
        return addressRepository.findAll();
    }

    public Address addAddress(Address address) {
        return addressRepository.save(address);
    }

}
