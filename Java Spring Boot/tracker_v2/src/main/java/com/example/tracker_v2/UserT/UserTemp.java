package com.example.tracker_v2.UserT;

public class UserTemp {

    private final Integer userId;
    private final String userFName;

    public UserTemp(Integer userId,
                 String userFName) {
        this.userId = userId;
        this.userFName = userFName;
    }

    public Integer getUserId() {
        return userId;
    }

    public String getUserFName() {
        return userFName;
    }

    @Override
    public String toString() {
        return "UserTemp{" +
                "userId=" + userId +
                ", userFName='" + userFName + '\'' +
                '}';
    }
}
