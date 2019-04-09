package com.example.demo.entities;

import com.sun.xml.internal.ws.api.ha.StickyFeature;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.UUID;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Account {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id", columnDefinition = "BINARY(16)", nullable = false)
    private UUID id;

    @Column(name = "create_date", nullable = false)
    @CreatedDate
    private Long createDate;

    @Column(name = "last_update",  nullable = false)
    @LastModifiedDate
    private Long lastUpdate;

    @Column(name = "is_active",columnDefinition = "BIT(1)",nullable = false)
    private  Boolean isActive;

    @JoinColumn(name = "user_id", foreignKey = @ForeignKey(name = "Fk_account_user"))
    @ManyToOne
    private User user;

    @Column(name = "firebase_token",columnDefinition = "TEXT")
    private String firebaseToken;

    @Column(name = "is_confirm",columnDefinition = "BIT(1)")
    private  Boolean isConfirm;

    @Column(name = "password",columnDefinition = "VARCHAR(255)",nullable = false)
    private String password;

    @Column(name = "social_gg_id",columnDefinition = "VARCHAR(255)")
    private String socialGgId;

    @Column(name = "social_id",columnDefinition = "VARCHAR(255)")
    private  String socialId;

    @Column(name = "username", columnDefinition = "NVARCHAR(50)",nullable = false)
    private  String username;

    @Column(name = "firebase_biz_token",columnDefinition = "TEXT")
    private String firebaseBizToken;

    public Account(User user) {
        this.user = user;
    }

    public String getSocialId() {
        return socialId;
    }

    public Account() {

    }

    public String getSocialGgId() {
        return socialGgId;
    }

    public void setSocialGgId(String socialGgId) {
        this.socialGgId = socialGgId;
    }

    public String getSocialId(String socialId) {
        return this.socialId;
    }

    public void setSocialId(String socialId) {
        this.socialId = socialId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirebaseBizToken() {
        return firebaseBizToken;
    }

    public void setFirebaseBizToken(String firebaseBizToken) {
        this.firebaseBizToken = firebaseBizToken;
    }

    public Account(Long createDate) {
        this.createDate = createDate;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
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

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getFirebaseToken() {
        return firebaseToken;
    }

    public void setFirebaseToken(String firebaseToken) {
        this.firebaseToken = firebaseToken;
    }

    public Boolean getConfirm() {
        return isConfirm;
    }

    public void setConfirm(Boolean confirm) {
        isConfirm = confirm;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
