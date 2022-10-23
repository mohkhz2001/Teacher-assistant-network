package com.mohkhz.tanetwork.Impl;

import com.mohkhz.tanetwork.Model.Entity.User;
import com.mohkhz.tanetwork.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.transaction.Transactional;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Mohammad mehdi khajhezadeh
 * @project TA-network
 * @email_support eng.khajhezadeh@gmail.com
 * @create 21 October 2022 at 1:18 AM
 */
@Service
public class UserDetailService implements UserDetailsService {

    @Autowired
    UserRepository repository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = repository.findByStudentId(Long.parseLong(username));

        Set<SimpleGrantedAuthority> simpleGrantedAuthorities = user.getRoles().stream()
                .map(item -> new SimpleGrantedAuthority(item.getRN()))
                .collect(Collectors.toSet());

        return new org.springframework.security.core.userdetails.User(username, user.getPassword(), simpleGrantedAuthorities);
    }
}
