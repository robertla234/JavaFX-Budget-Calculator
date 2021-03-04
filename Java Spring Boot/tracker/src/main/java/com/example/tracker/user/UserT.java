package com.example.tracker.user;

import javax.persistence.*;

@Entity
@Table
public class UserT {
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
    private Long id;
    private String username;
    private String password;
    private String email;
    private String name;
    private int initialAmount;

    public UserT() {
    }

    public UserT(Long id,
                 String username,
                 String password,
                 String email,
                 String name,
                 int initialAmount) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.name = name;
        this.initialAmount = initialAmount;
    }

    public UserT(String username,
                 String password,
                 String email,
                 String name,
                 int initialAmount) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.name = name;
        this.initialAmount = initialAmount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getInitialAmount() {
        return initialAmount;
    }

    public void setInitialAmount(int initialAmount) {
        this.initialAmount = initialAmount;
    }

    @Override
    public String toString() {
        return "UserT{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", initialAmount=" + initialAmount +
                '}';
    }
}
