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
    private String email;
    private String name;

    public UserT() {
    }

    public UserT(Long id,
                 String username,
                 String email,
                 String name) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.name = name;
    }

    public UserT(String username,
                 String email,
                 String name) {
        this.username = username;
        this.email = email;
        this.name = name;
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

    @Override
    public String toString() {
        return "UserT{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
