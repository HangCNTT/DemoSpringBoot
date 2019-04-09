package com.example.demo.controllers;

import com.example.demo.entities.Address;
import com.example.demo.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/address")
public class AddressController {
    @Autowired
    private AddressService addressService;

    @GetMapping("/address")
    public ResponseEntity getAddress(){
       return   ResponseEntity.ok(addressService.getAll());
    }

    @PostMapping(value = "/createaddres")
    public Address createAddress(@RequestBody Address address){
        return addressService.createAddress(address.getId(),address.getName());
    }

    @PutMapping(value = "/updateaddress")
    public  ResponseEntity updateAddress(@RequestParam(value = "id") String id,@RequestBody String name)
    {
        Address address = addressService.updateAddress(id,name);
        return ResponseEntity.ok().body(address);
    }

    @DeleteMapping("/deleteaddress")
    public  ResponseEntity deleteAddress(@RequestParam(value = "id") String id)
    {
        Address address = addressService.deleteAddress(id);
        return ResponseEntity.ok(address);
    }
}
