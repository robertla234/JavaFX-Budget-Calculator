package com.example.tracker_v2.UserDBAuthentication;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static com.example.tracker_v2.Security.ApplicationUserRole.ADMIN;
import static com.example.tracker_v2.Security.ApplicationUserRole.USER;

@Repository("pseudo")
public class PseudoAppDaoService implements ApplicationUserDao{

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public PseudoAppDaoService(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Optional<ApplicationUser> selectApplicationUserByUsername(String username){
        return getApplicationUsers()
                .stream()
                .filter(applicationUser -> username.equals(applicationUser.getUsername()))
                .findFirst();
    }

    private List<ApplicationUser> getApplicationUsers() {
        List<ApplicationUser> applicationUsers = Lists.newArrayList(
                new ApplicationUser(
                        (List<? extends GrantedAuthority>) USER.getGrantedAuthorities(),
                        passwordEncoder.encode("password"),
                        "user",
                        true,
                        true,
                        true,
                        true
                ),
                new ApplicationUser(
                        (List<? extends GrantedAuthority>) ADMIN.getGrantedAuthorities(),
                        passwordEncoder.encode("password"),
                        "admin",
                        true,
                        true,
                        true,
                        true
                )
        );

        return applicationUsers;
    }
}
