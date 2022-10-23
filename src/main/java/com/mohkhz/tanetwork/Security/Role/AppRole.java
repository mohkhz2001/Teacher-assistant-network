package com.mohkhz.tanetwork.Security.Role;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Mohammad mehdi khajhezadeh
 * @project TA-network
 * @email_support eng.khajhezadeh@gmail.com
 * @create 21 October 2022 at 1:07 AM
 */
public enum AppRole {
    ADMIN(1L, Set.of(UserPermission.STD_WORKSHOP, UserPermission.TA_WORKSHOP)),
    STD(2L, Set.of(UserPermission.STD_WORKSHOP));

    private Long id;
    private Set<UserPermission> permissions;

    AppRole(Long id, Set<UserPermission> permissions) {
        this.id = id;
        this.permissions = permissions;
    }

    public Long getId() {
        return id;
    }

    public Set<UserPermission> getPermission() {
        return permissions;
    }

    public Set<SimpleGrantedAuthority> getPermissions() {

        Set<SimpleGrantedAuthority> collect = getPermission().stream().map(p -> new SimpleGrantedAuthority(p.getPermission()))
                .collect(Collectors.toSet());

        collect.add(new SimpleGrantedAuthority(this.name()));

        return collect;
    }
}
