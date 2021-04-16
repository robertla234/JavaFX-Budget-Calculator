package com.example.tracker_v3.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name="\"User\"")
public class User implements UserDetails {
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
    @JsonIgnore
    private String role;
    private String fName;
    private String lName;
    private String phone;
    @JsonIgnore
    private String password;
    @JsonIgnore
    private boolean isAccountNonLocked;

    public User() {
    }

    public User(Long id, String username,
                String email, String role,
                String fName, String lName,
                String phone, String password,
                boolean isAccountNonLocked) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.role = role;
        this.fName = fName;
        this.lName = lName;
        this.phone = phone;
        this.password = password;
        this.isAccountNonLocked = isAccountNonLocked;
    }

    public User(String username, String email,
                String role, String fName,
                String lName, String phone,
                String password,
                boolean isAccountNonLocked) {
        this.username = username;
        this.email = email;
        this.role = role;
        this.fName = fName;
        this.lName = lName;
        this.phone = phone;
        this.password = password;
        this.isAccountNonLocked = isAccountNonLocked;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean getAccountNonLocked() {
        return isAccountNonLocked;
    }

    public void setAccountNonLocked(boolean accountNonLocked) {
        isAccountNonLocked = accountNonLocked;
    }

    @JsonIgnore
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    } //TODO CHANGE LATER

    @JsonIgnore
    @Override
    public boolean isAccountNonExpired() {
        return true;
    } //TODO CHANGE LATER

    @JsonIgnore
    @Override
    public boolean isAccountNonLocked() {
        return isAccountNonLocked;
    }

    @JsonIgnore
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    } //TODO CHANGE LATER

    @JsonIgnore
    @Override
    public boolean isEnabled() {
        return true;
    } //TODO CHANGE LATER

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", role='" + role + '\'' +
                ", fName='" + fName + '\'' +
                ", lName='" + lName + '\'' +
                ", phone='" + phone + '\'' +
                ", password='" + password + '\'' +
                ", isAccountNonLocked=" + isAccountNonLocked +
                '}';
    }
}
