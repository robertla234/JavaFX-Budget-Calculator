package com.example.tracker_v2.Security;

import com.google.common.collect.Sets;

import java.util.Set;

import static com.example.tracker_v2.Security.ApplicationUserPermission.*;

public enum ApplicationUserRole {
    USER(Sets.newHashSet()),
    ADMIN(Sets.newHashSet(WALLET_READ, WALLET_WRITE,
            USER_READ, USER_WRITE));

    private final Set<ApplicationUserPermission> permission;

    ApplicationUserRole(Set<ApplicationUserPermission> permissions){
        this.permission = permissions;
    }
}
