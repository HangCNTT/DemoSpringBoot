package com.example.demo.repositories;

import com.example.demo.entities.Account;
import com.example.demo.models.CreateAccountModel;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;
import java.util.UUID;

public interface AccountRepository extends CrudRepository<Account, UUID> {

    ArrayList<Account> findAccountByCreateDate(Long createDate);

}
