package com.example.demo.entities;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Profile  implements Serializable {
    @Id
    //Tạo tự động
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id", columnDefinition = "BINARY(16)", nullable = false)
    private UUID id;
    @Column(name = "name", columnDefinition = "NVARCHAR(255)", nullable = false)
    private String name;
    @JoinColumn(name = "address_id", foreignKey = @ForeignKey(name = "Fk_profile_address"))
    @ManyToOne
    private Address address;

    @Column(name = "create_date", nullable = false)
    @CreatedDate
    private Long createDate;
    @Column(name = "last_update",  nullable = false)
    @LastModifiedDate
    private Long lastUpdate;

    @Column(name = "email",columnDefinition = "VARCHAR(50)", nullable = false)
    private String email;

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Column(name = "date_of_birth", nullable = false)
    private Long dateOfBirth;

    @Column(name = "description",columnDefinition = "VARCHAR(255)")
    private String description;

    @Column(name = "gender",columnDefinition = "INTEGER(11)",nullable = false)
    private Integer gender;

    @Column(name = "is_active",columnDefinition = "BIT(1)")
    private  Boolean isActive;

    @Column(name = "phone",columnDefinition = "VARCHAR(50)",nullable = false)
    private String phone;

    @Column(name = "url_avatar",columnDefinition = "VARCHAR(2000)",nullable = false)
    private String urlAvatar;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Long createDate) {
        this.createDate = createDate;
    }

    public Long getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Long lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public Profile() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Profile(String name, Long createDate, Long lastUpdate, String email) {
        this.name = name;
        this.createDate = createDate;
        this.lastUpdate = lastUpdate;
        this.email = email;
    }


    public Long getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Long dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUrlAvatar() {
        return urlAvatar;
    }

    public void setUrlAvatar(String urlAvatar) {
        this.urlAvatar = urlAvatar;
    }
}

