package com.example.demo.services;

import com.example.demo.entities.Address;
import com.example.demo.entities.Profile;
import com.example.demo.models.CreateAccountModel;
import com.example.demo.repositories.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.UUID;

@Service
public class ProfileService {
    @Autowired
    private ProfileRepository profileRepository;
    @Autowired
    private AddressService addressService;

    public ArrayList<Profile> getAll() {
        return ((ArrayList<Profile>) profileRepository.findAll());
    }

    public  ArrayList<Profile> getByEmail(String email){
        return profileRepository.findByEmail(email);
    }

    public Profile createProfile(CreateAccountModel createAccountModel) {
        Profile profile = new Profile();
        Address address = addressService.getById(createAccountModel.getAddressId());
        profile.setAddress(address);
        profile.setEmail(createAccountModel.getEmail());
        profile.setName(createAccountModel.getName());
        profile.setDateOfBirth(createAccountModel.getDateOfBirth());
        profile.setGender(createAccountModel.getGender());
        profile.setUrlAvatar(createAccountModel.getUrlAvatar());
        profile.setPhone(createAccountModel.getPhone());
        profile.setDescription(createAccountModel.getDescription());
        profile = profileRepository.save(profile);
        return profile;

    }
    //Update
    public Profile updateEmail(UUID id,String email){
        Profile profile= profileRepository.findById(id).orElse(null);
        if(profile !=null){
            profile.setEmail(email);
            profile = profileRepository.save(profile);
        }
        return profile;
    }
    //Delete
    public  Profile delete(UUID id){
        Profile profile = profileRepository.findById(id).orElse(null);
        if(profile != null)
        {
            profileRepository.deleteById(id);
            profile = profileRepository.save(profile);
        }
        return profile;
    }

}
