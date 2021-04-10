package com.example.tracker_v3.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserRService {

    private final UserRRepository userRRepository;

    @Autowired
    public UserRService(UserRRepository userRRepository) {
        this.userRRepository = userRRepository;
    }

    public List<UserR> getUsers() {
        return userRRepository.findAll();
    }

    public List<UserR> getUser(List<Long> userid){
        return userRRepository.findAllById(userid);
    }

    public void addNewUser(UserR user) {
        Optional<UserR> userTOptional = userRRepository.findUserRByEmail(user.getUserEmail());
        if (userTOptional.isPresent()){
            throw new IllegalStateException("Email is taken.");
        }
        userRRepository.save(user);
    }

    public void deleteUser(Long userid) {
        boolean exists = userRRepository.existsById(userid);
        if (!exists) {
            throw new IllegalStateException("Student with id " + userid + " does not exist.");
        }
        userRRepository.deleteById(userid);
    }

    @Transactional
    public void updateUser(Long usertid, String fname, String lname, String email) {
        UserR user = userRRepository.findById(usertid)
                .orElseThrow(() -> new IllegalStateException(
                        "Student with id " + usertid + " does not exist."
                ));
        if (fname != null && lname != null &&
                fname.length() > 0 && lname.length() > 0 &&
                !Objects.equals(user.getUserFName(), fname) &&
                !Objects.equals(user.getUserLName(), lname)){
            user.setUserFName(fname);
            user.setUserLName(lname);
        }
        if (email != null &&
                email.length() > 0 &&
                !Objects.equals(user.getUserEmail(), email)){
            Optional<UserR> userTOptional = userRRepository.findUserRByEmail(email);
            if (userTOptional.isPresent()){
                throw new IllegalStateException("Email is already being used.");
            }
            user.setUserEmail(email);
        }
    }
}
