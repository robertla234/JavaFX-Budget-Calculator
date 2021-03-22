package com.example.tracker.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/user")
public class UserTController {

    private final UserTService userTService;

    @Autowired
    public UserTController(UserTService userTService) {
        this.userTService = userTService;
    }

    @GetMapping
    public List<UserT> getUsers(){
        return userTService.getUsers();
    }

    @GetMapping(path = "/test")
    public String testGet(){ return "Test Get"; }

    @PostMapping
    public void registerNewUserT(@RequestBody UserT userT){
        userTService.addNewUser(userT);
    }

    @DeleteMapping(path = "{userTId}")
    public void deleteUserT(@PathVariable("userTId") Long usertid){
        userTService.deleteUserT(usertid);
    }

    @PutMapping(path = "{userTId}")
    public void updateUserT(
            @PathVariable("userTId") Long usertid,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email){
        userTService.updateUserT(usertid, name, email);
    }

}
