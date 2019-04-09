package com.example.demo.entities;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Address {
    @Id
    @Column(name = "id", columnDefinition = "VARCHAR(5)",nullable = false)
    private String id;

    @Column(name = "nameProvince",columnDefinition = "NVARCHAR(100)",nullable = false)
    private  String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public Address(){

    }
}
