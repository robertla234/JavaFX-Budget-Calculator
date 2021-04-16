package com.example.tracker_v3.userR;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "api/v3/user")
public class UserRController {

    private final UserRService userRService;

    @Autowired
    public UserRController(UserRService userRService) {
        this.userRService = userRService;
    }

    @GetMapping
    //@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public List<UserR> getUsers(){
        return userRService.getUsers();
    }

    @GetMapping(path = "{userId}")
    //@PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
    public List<UserR> getUser(@PathVariable("userId") Long userid) {
        List<Long> userList = new ArrayList<Long>(){{ add(userid); }};
        return userRService.getUser(userList);
    }

    @PostMapping
    public void registerNewUser(@RequestBody UserR user){
        userRService.addNewUser(user);
    }

    @DeleteMapping(path = "{userId}")
    //@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public void deleteUser(@PathVariable("userId") Long userid){
        userRService.deleteUser(userid);
    }

    @PutMapping(path = "{userTId}")
    public void updateUserT(
            @PathVariable("userTId") Long userid,
            @RequestParam(required = false) String fname,
            @RequestParam(required = false) String lname,
            @RequestParam(required = false) String email){
        userRService.updateUser(userid, fname, lname, email);
    }

}
