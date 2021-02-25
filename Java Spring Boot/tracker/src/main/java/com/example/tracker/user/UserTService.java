package com.example.tracker.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserTService {

    private final UserTRepository userTRepository;

    @Autowired
    public UserTService(UserTRepository userTRepository) {
        this.userTRepository = userTRepository;
    }

    public List<UserT> getUsers(){
        return userTRepository.findAll();
    }

    public void addNewUser(UserT userT) {
        Optional<UserT> userTOptional = userTRepository.findUserTByEmail(userT.getEmail());
        if (userTOptional.isPresent()){
            throw new IllegalStateException("Email is taken.");
        }
        userTRepository.save(userT);
    }

    public void deleteUserT(Long usertid) {
        boolean exists = userTRepository.existsById(usertid);
        if (!exists) {
            throw new IllegalStateException("Student with id " + usertid + " does not exist.");
        }
        userTRepository.deleteById(usertid);
    }

    @Transactional
    public void updateUserT(Long usertid, String name, String email) {
        UserT userT = userTRepository.findById(usertid)
                .orElseThrow(() -> new IllegalStateException(
                        "Student with id " + usertid + " does not exist."
                ));
        if (name != null &&
        name.length() > 0 &&
        !Objects.equals(userT.getName(), name)){
            userT.setName(name);
        }
        if (email != null &&
        email.length() > 0 &&
        !Objects.equals(userT.getEmail(), email)){
            Optional<UserT> userTOptional = userTRepository.findUserTByEmail(email);
            if (userTOptional.isPresent()){
                throw new IllegalStateException("Email is already being used.");
            }
            userT.setEmail(email);
        }
    }
}
