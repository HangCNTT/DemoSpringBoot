package com.example.demo.controllers;

import com.example.demo.entities.Account;
import com.example.demo.entities.Profile;
import com.example.demo.entities.User;
import com.example.demo.models.CreateAccountModel;
import com.example.demo.models.UpdateAccountModel;
import com.example.demo.models.UserViewModel;
import com.example.demo.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.UUID;

@RestController
@RequestMapping("/account")
public class AccountController {
    @Autowired
    AccountService accountService;

    @GetMapping("/getaccount")
    public ResponseEntity getAccount(){
        return ResponseEntity.ok(accountService.getAll());
    }

    @RequestMapping("/getByCreatedDate")
    public  ResponseEntity getAccountByCreateDate(@RequestParam(value = "createDate")Long createDate){
        if (createDate == null) {
            return ResponseEntity.badRequest().build();
        }
        ArrayList<Account> accounts = accountService.getByCreateDate(createDate);
        return ResponseEntity.ok(accounts);
    }

    @PostMapping(value = "/createaccount")
    public UserViewModel createAccount(@RequestBody CreateAccountModel createAccountModel)
    {
        //Create theo viewmodel  show theo yêu cầu
        Account account = accountService.createAccount(createAccountModel);
        UserViewModel userViewModel = new UserViewModel(account);
        return userViewModel;
    }
    @PutMapping(value = "/updateaccount")
    public ResponseEntity updateAccount(@RequestParam(value = "id")UUID id,@RequestBody String email){
        Account account = accountService.updateAccount(id,email);
        return ResponseEntity.ok().body(account);
    }

    @PutMapping(value = "/updateAllAccount")
    public  UserViewModel updateAllAccount(@RequestBody UpdateAccountModel updateAccountModel)
    {
        Account account = accountService.updateAllAccount(updateAccountModel);
        UserViewModel userViewModel = new UserViewModel(account);
        return  userViewModel;
    }
    @DeleteMapping(value = "/deleteaccount")
    public ResponseEntity<Account> deleteAccount(@RequestParam(value = "id")UUID id){
        Account account = accountService.deleteAccount(id);
        return ResponseEntity.ok(account);
    }
}
