package com.example.demo.entities;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.UUID;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class User {
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

    @JoinColumn(name = "profile_id", foreignKey = @ForeignKey(name = "Fk_user_profile"))
    @ManyToOne
    private Profile profile;

    @Column(name = "is_active",columnDefinition = "BIT(1)")
    private  Boolean isActive;

    @Column(name = "point",columnDefinition = "INTEGER(11)")
    private  Integer point;

    @Column(name = "role",columnDefinition = "INTEGER(11)")
    private Integer role;

    @Column(name = "blockchain_role",columnDefinition = "INTEGER(11)")
    private Integer blockchainRole;

    public User(Long createDate) {
        this.createDate = createDate;
    }

    public User() {

    }

    public User(Profile profile) {
        this.profile = profile;
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

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public Integer getPoint() {
        return point;
    }

    public void setPoint(Integer point) {
        this.point = point;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    public Integer getBlockchainRole() {
        return blockchainRole;
    }

    public void setBlockchainRole(Integer blockchainRole) {
        this.blockchainRole = blockchainRole;
    }
}
