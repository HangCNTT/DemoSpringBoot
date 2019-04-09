package com.example.demo.repositories;

import com.example.demo.entities.Address;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

public interface AddressRepository extends CrudRepository<Address,String> {

}