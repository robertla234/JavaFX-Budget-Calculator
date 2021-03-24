package com.example.tracker_v2.Security;

public enum ApplicationUserPermission {
    USER_READ("user:read"),
    USER_WRITE("user:read"),
    USER_DELETE("user:delete"),
    WALLET_READ("wallet:read"),
    WALLET_WRITE("wallet:write"),
    WALLET_DELETE("wallet:delte");

    private final String permission;

    ApplicationUserPermission(String permission){
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
