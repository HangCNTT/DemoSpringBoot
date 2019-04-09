package com.example.demo.controllers;

import com.example.demo.entities.Profile;
import com.example.demo.models.CreateAccountModel;
import com.example.demo.services.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.UUID;

@RestController
@RequestMapping("/profile")
public class HomeController {
    @Autowired
    private ProfileService profileService;

    @GetMapping("/getprofile")
    public ResponseEntity getProfile() {
        return ResponseEntity.ok(profileService.getAll());
    }

    @PostMapping(value = "/createprofile")
    public Profile saveProfile(@RequestBody CreateAccountModel createAccountModel) {
        return profileService.createProfile(createAccountModel);
    }

    @PutMapping(value = "/updateprofile")
    public ResponseEntity updateEmail(@RequestParam(value = "id")UUID id,@RequestBody String email) {
        Profile profiles = profileService.updateEmail(id,email);
        return ResponseEntity.ok().body(profiles);
    }

    @RequestMapping(value = "/getbyemail")
    public ResponseEntity findProfile(@RequestParam(value = "email") String email) {
        if (email.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        ArrayList<Profile> profile = profileService.getByEmail(email);
        return ResponseEntity.ok(profile);
    }
    @DeleteMapping(value = "/delete")
    public  ResponseEntity deleteProfile(@RequestParam(value = "id") UUID id){
        Profile profile = profileService.delete(id);
        return  ResponseEntity.ok(profile);
    }
}
