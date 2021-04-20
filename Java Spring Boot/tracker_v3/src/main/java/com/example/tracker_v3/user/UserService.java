package com.example.tracker_v3.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public List<User> getUser(List<Long> userid){
        List<User> userList= userRepository.findAllById(userid);
        if (!userList.isEmpty()){
            return userList;
        }
        else {
            throw new IllegalStateException("User with id " + userid + " does not exist.");
        }
    }

    public void addNewUser(User user) {
        Optional<User> userOptional = userRepository.findUserByEmail(user.getEmail());
        if (userOptional.isPresent()){
            throw new IllegalStateException("Email is taken.");
        }
        userRepository.save(user);
    }

    public void deleteUser(Long userid) {
        boolean exists = userRepository.existsById(userid);
        if (!exists) {
            throw new IllegalStateException("User with id " + userid + " does not exist.");
        }
        userRepository.deleteById(userid);
    }

    @Transactional
    public void updateUser(Long usertid, String fname, String lname, String email) {
        User user = userRepository.findById(usertid)
                .orElseThrow(() -> new IllegalStateException(
                        "Student with id " + usertid + " does not exist."
                ));
        if (fname != null && lname != null &&
                fname.length() > 0 && lname.length() > 0 &&
                !Objects.equals(user.getfName(), fname) &&
                !Objects.equals(user.getlName(), lname)){
            user.setfName(fname);
            user.setlName(lname);
        }
        if (email != null &&
                email.length() > 0 &&
                !Objects.equals(user.getEmail(), email)){
            Optional<User> userOptional = userRepository.findUserByEmail(email);
            if (userOptional.isPresent()){
                throw new IllegalStateException("Email is already being used.");
            }
            user.setEmail(email);
        }
    }

}
