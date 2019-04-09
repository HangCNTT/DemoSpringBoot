package com.example.demo.services;

import com.example.demo.entities.Address;
import com.example.demo.repositories.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class AddressService {
    @Autowired
    private AddressRepository addressRepository;

    public ArrayList<Address> getAll() {
        return (ArrayList<Address>) addressRepository.findAll();
    }

    public Address createAddress(String id, String name) {
        Address address = new Address();
        address.setId(id);
        address.setName(name);
        address = addressRepository.save(address);
        return address;
    }

    public Address updateAddress(String id, String name) {
        Address address = addressRepository.findById(id).orElse(null);
        if (address != null) {
            address.setName(name);
            address = addressRepository.save(address);
        }
        return address;
    }

    public Address deleteAddress(String id) {
        Address address = addressRepository.findById(id).orElse(null);
        if (address != null) {
            addressRepository.delete(address);
            address = addressRepository.save(address);
        }
        return address;
    }

    public Address getById(String id) {
        try {
            return addressRepository.findById(id).orElse(null);
        } catch (Exception ex) {
            return null;
        }
    }
}
