package com.example.tracker_v3.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "api/v3/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    //@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public List<User> getUsers(){
        return userService.getUsers();
    }

    @GetMapping(path = "{userId}")
    //@PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
    public List<User> getUser(@PathVariable("userId") Long userid) {
        List<Long> userList = new ArrayList<Long>(){{ add(userid); }};
        return userService.getUser(userList);
    }

    @PostMapping
    public void registerNewUser(@RequestBody User user){
        userService.addNewUser(user);
    }

    @DeleteMapping(path = "{id}")
    //@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public void deleteUser(@PathVariable("id") Long id){
        userService.deleteUser(id);
    }

    @PutMapping(path = "{id}")
    public void updateUserT(
            @PathVariable("id") Long userid,
            @RequestParam(required = false) String fname,
            @RequestParam(required = false) String lname,
            @RequestParam(required = false) String email){
        userService.updateUser(userid, fname, lname, email);
    }

}
