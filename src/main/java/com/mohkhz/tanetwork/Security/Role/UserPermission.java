package com.mohkhz.tanetwork.Security.Role;

/**
 * @author Mohammad mehdi khajhezadeh
 * @project TA-network
 * @email_support eng.khajhezadeh@gmail.com
 * @create 21 October 2022 at 1:08 AM
 */
public enum UserPermission {
    TA_WORKSHOP(3L , "TA:WORKSHOP"),
    STD_WORKSHOP(4L , "STD:WORKSHOP");

    private Long id;
    private String permission;

    UserPermission(Long id, String permission) {
        this.id = id;
        this.permission = permission;
    }

    public Long getId() {
        return id;
    }

    public String getPermission() {
        return permission;
    }

}
