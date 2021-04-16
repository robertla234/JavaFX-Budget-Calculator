package com.example.tracker_v3.user;




import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table
public class UserR {
    @Id
    @SequenceGenerator(
            name = "tracker_sequence",
            sequenceName = "tracker_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "tracker_sequence"
    )
    private Long userId;
    private String userEmail;
    @JsonIgnore
    private String userRole;
    private String userFName;
    private String userLName;
    private String userPhone;
    @JsonIgnore
    private String userPassword;

    public UserR() {
    }

    public UserR(Long userId, String userEmail,
                 String userRole, String userFName,
                 String userLName, String userPhone,
                 String userPassword) {
        this.userId = userId;
        this.userEmail = userEmail;
        this.userRole = userRole;
        this.userFName = userFName;
        this.userLName = userLName;
        this.userPhone = userPhone;
        this.userPassword = userPassword;
    }

    public UserR(String userEmail,
                 String userRole, String userFName,
                 String userLName, String userPhone,
                 String userPassword) {
        this.userEmail = userEmail;
        this.userRole = userRole;
        this.userFName = userFName;
        this.userLName = userLName;
        this.userPhone = userPhone;
        this.userPassword = userPassword;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public String getUserFName() {
        return userFName;
    }

    public void setUserFName(String userFName) {
        this.userFName = userFName;
    }

    public String getUserLName() {
        return userLName;
    }

    public void setUserLName(String userLName) {
        this.userLName = userLName;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    @Override
    public String toString() {
        return "UserR{" +
                "userId=" + userId +
                ", userEmail='" + userEmail + '\'' +
                ", userRole='" + userRole + '\'' +
                ", userFName='" + userFName + '\'' +
                ", userLName='" + userLName + '\'' +
                ", userPhone='" + userPhone + '\'' +
                ", userPassword='" + userPassword + '\'' +
                '}';
    }
}
