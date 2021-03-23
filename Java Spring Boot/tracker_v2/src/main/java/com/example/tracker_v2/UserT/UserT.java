package com.example.tracker_v2.UserT;

public class UserT {

    private final Integer userId;
    private final String userRole;
    private final String userFName;
    private final String userLName;
    private final String userEmail;
    private final String userPhone;
    private final String userPassword;

    public UserT(Integer userId, String userRole,
                 String userFName, String userLName,
                 String userEmail, String userPhone,
                 String userPassword) {
        this.userId = userId;
        this.userRole = userRole;
        this.userFName = userFName;
        this.userLName = userLName;
        this.userEmail = userEmail;
        this.userPhone = userPhone;
        this.userPassword = userPassword;
    }

    public Integer getUserId() {
        return userId;
    }

    public String getUserRole() {
        return userRole;
    }

    public String getUserFName() {
        return userFName;
    }

    public String getUserLName() {
        return userLName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public String getUserPassword() {
        return userPassword;
    }
}
