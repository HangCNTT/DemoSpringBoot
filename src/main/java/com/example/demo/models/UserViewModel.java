package com.example.demo.models;

import com.example.demo.entities.Account;
import com.example.demo.entities.Profile;
import com.example.demo.entities.User;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.jws.soap.SOAPBinding;
import java.util.UUID;

@JsonIgnoreProperties(value = {"role"})
public class UserViewModel {
    private UUID Id;
    private String name;
    private String username;
    private String cityName;
    private String email;
    private Long dateOfBirth;
    private String gender;
    private String phone;
    private String description;
    private String urlAvatar;
    private Integer point;
    private Integer role;
    private String firebaseToken;
    private String password;
    private String socialGgId;
    private String socialId;
    private String firebaseBizToken;

    //Tạo constructor trong UserViewModel tương ứng với các thuộc tính được get() theo yêu cầu từ AccountController

    public UserViewModel(Account account) {
        this.Id = account.getId();
        User user = account.getUser();
        Profile profile = user.getProfile();
        this.name = profile.getName();
        this.cityName = profile.getAddress().getName();
        this.email = profile.getEmail();
        this.gender = profile.getGender().toString();
        this.dateOfBirth = profile.getDateOfBirth();
        this.phone = profile.getPhone();
        this.urlAvatar = profile.getUrlAvatar();
        this.description = profile.getDescription();
        this.point = user.getPoint();
        this.role = user.getRole();
        this.firebaseBizToken = account.getFirebaseBizToken();
        this.password = account.getPassword();
        this.socialGgId = account.getSocialGgId();
        this.socialId = account.getSocialId();
        this.firebaseToken =account.getFirebaseToken();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Long getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Long dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getUrlAvatar() {
        return urlAvatar;
    }

    public void setUrlAvatar(String urlAvatar) {
        this.urlAvatar = urlAvatar;
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

    public String getFirebaseToken() {
        return firebaseToken;
    }

    public void setFirebaseToken(String firebaseToken) {
        this.firebaseToken = firebaseToken;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSocialGgId() {
        return socialGgId;
    }

    public void setSocialGgId(String socialGgId) {
        this.socialGgId = socialGgId;
    }

    public String getSocialId() {
        return socialId;
    }

    public void setSocialId(String socialId) {
        this.socialId = socialId;
    }

    public String getFirebaseBizToken() {
        return firebaseBizToken;
    }

    public void setFirebaseBizToken(String firebaseBizToken) {
        this.firebaseBizToken = firebaseBizToken;
    }

    public UserViewModel() {
    }

    public UUID getId() {
        return Id;
    }

    public void setId(UUID id) {
        Id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
