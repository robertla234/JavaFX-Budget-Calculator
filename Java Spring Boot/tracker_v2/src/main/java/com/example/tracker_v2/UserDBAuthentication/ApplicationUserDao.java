package com.example.tracker_v2.UserDBAuthentication;

import java.util.Optional;

public interface ApplicationUserDao {

    public Optional<ApplicationUser> selectApplicationUserByUsername(String username);

}
