package com.example.demo.services;

import com.example.demo.entities.Profile;
import com.example.demo.entities.User;
import com.example.demo.models.CreateAccountModel;
import com.example.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.UUID;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ProfileService profileService;

    public ArrayList<User> getAll(){
        return (ArrayList<User>) userRepository.findAll();
    }

    public  User createUser(CreateAccountModel createAccountModel){
        User user = new User();
        Profile profile = profileService.createProfile(createAccountModel);
        user.setProfile(profile);
        return userRepository.save(user);
    }

    public  User updateUser(UUID id,String email){
        User user = userRepository.findById(id).orElse(null);
        if (user != null )
        {
            Profile profile = profileService.updateEmail(id,email);
            user.setProfile(profile);
            userRepository.save(user);
        }
        return user;
    }
}
