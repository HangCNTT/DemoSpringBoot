package com.example.demo.services;

import com.example.demo.entities.Account;
import com.example.demo.entities.Profile;
import com.example.demo.entities.User;
import com.example.demo.models.CreateAccountModel;
import com.example.demo.models.UpdateAccountModel;
import com.example.demo.models.UserViewModel;
import com.example.demo.repositories.AccountRepository;
import com.example.demo.repositories.ProfileRepository;
import com.example.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.UUID;

@Service
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private ProfileRepository profileRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private ProfileService profileService;

    public ArrayList<Account> getAll()
    {
        return (ArrayList<Account>) accountRepository.findAll();
    }

    public  ArrayList<Account> getByCreateDate(Long createDate){

        return accountRepository.findAccountByCreateDate(createDate);
    }

    public Account createAccount(CreateAccountModel createAccountModel){
        Account account = new Account();
        account.setActive(true);
        account.setUsername(createAccountModel.getUsername());
        account.setSocialId(createAccountModel.getSocialId());
        account.setFirebaseToken(createAccountModel.getFirebaseToken());
        account.setFirebaseBizToken(createAccountModel.getFirebaseToken());
        account.setPassword(createAccountModel.getPassword());
        User user = userService.createUser(createAccountModel);
        account.setUser(user);
        return accountRepository.save(account);
    }

    public Account updateAccount(UUID id,String email){
        Account account = accountRepository.findById(id).orElse(null);
        if (account != null )
        {
            //Truy xuất email từ profile thông qua user
            User user = account.getUser();
            user.getId();
            Profile profile = user.getProfile();
            profile.setEmail(email);
            profileRepository.save(profile);
            account = accountRepository.save(account);
        }
        return account;
    }

    //Update All từ UpdateAccountModel
    public  Account updateAllAccount(UpdateAccountModel updateAccountModel)
    {
        Account account = accountRepository.findById(updateAccountModel.getId()).orElse(null);
        if(account != null){
            account.setLastUpdate(updateAccountModel.getLastUpdate());
            account.setPassword(updateAccountModel.getPassword());
            account.setActive(updateAccountModel.getActive());
            User user = account.getUser();
            user.getId();
            Profile profile = user.getProfile();
            profile.setDescription(updateAccountModel.getDescription());
            profile.setPhone(updateAccountModel.getPhone());
            profileRepository.save(profile);
            account = accountRepository.save(account);
        }
        return account;
    }
    public Account deleteAccount(UUID id)
    {
        Account account = accountRepository.findById(id).orElse(null);
        if (account != null)
        {
             accountRepository.deleteById(id);
             accountRepository.save(account);
        }
        return account;
    }
}
