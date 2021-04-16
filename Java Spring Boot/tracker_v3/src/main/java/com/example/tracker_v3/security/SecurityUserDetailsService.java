package com.example.tracker_v3.security;

import com.example.tracker_v3.userR.UserR;
import com.example.tracker_v3.userR.UserRRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class SecurityUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRRepository userRRepository;

    @Override
    public UserDetails loadUserByEmail(String email) throws UsernameNotFoundException {
        UserR user = userRRepository.findUserRByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User email not present"));
        return user;
    }
    public void createUser(UserDetails user){
        userRRepository.save((UserR) user);
    }
}
