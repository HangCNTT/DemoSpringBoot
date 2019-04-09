package com.example.demo.repositories;

import com.example.demo.entities.Profile;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.ArrayList;
import java.util.UUID;

public interface ProfileRepository extends CrudRepository<Profile, UUID> {
    //Such as Query
    ArrayList<Profile> findByNameContaining(String name);

    //SELECT * FROM Profile WHERE email = 'para_email'
    ArrayList<Profile> findByEmail(String email);

//    ArrayList<Profile> findByGender(Integer gender);
//
//    //select * from profile where name like '%:name%' and is_active= true order by create_date
//    ArrayList<Profile> findByNameContainingAndActiveOrderByCreateDate( String name, Boolean isActive);
//
//    //count(*) from profile where name like '%:name%' and is_active= true
//    Integer countAllByNameContainingAndActive(String name,Boolean isActive);
}
