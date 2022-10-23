package com.mohkhz.tanetwork.Impl;

import com.mohkhz.tanetwork.Model.Entity.Role;
import com.mohkhz.tanetwork.Model.Entity.User;
import com.mohkhz.tanetwork.Repository.UserRepository;
import com.mohkhz.tanetwork.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.mohkhz.tanetwork.Security.Role.AppRole.*;

/**
 * @author Mohammad mehdi khajhezadeh
 * @project TA-network
 * @email_support eng.khajhezadeh@gmail.com
 * @create 21 October 2022 at 1:05 AM
 */
@Service
public class UserImplementation implements UserService {

    @Autowired
    UserRepository repository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public User findByStudentId(String studentId) {
        return repository.findByStudentId(Long.parseLong(studentId));
    }

    @Override
    public User findByPhoneNumber(Long phoneNumber) {
        return null;
    }

    @Override
    public User newUser(User user) {
        try {

            if (user.getId() == null) {

                user.setPassword(passwordEncoder.encode(user.getPassword()));

                user.setRoles(
                        STD.getPermission().stream()
                                .map(item -> new Role(item.getId(), item.getPermission()))
                                .collect(Collectors.toSet())
                );
            } else {

                User u = repository.findByStudentId(user.getStudentId());
                user.setPassword(u.getPassword());
                user.setRoles(u.getRoles());

            }


            return repository.save(user);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<User> getAll() {
        return repository.findAll();
    }

    @Override
    public User newUserAdmin(User user) {

        user.setPassword(passwordEncoder.encode(user.getPassword()));

        user.setRoles(
                ADMIN.getPermission().stream()
                        .map(item -> new Role(item.getId(), item.getPermission()))
                        .collect(Collectors.toSet())
        );
        user.getRoles().add(new Role(ADMIN.getId(), ADMIN.name()));

        return repository.save(user);
    }

    @Override
    public void deleteUser(Long stdId) {
        User user = findByStudentId(String.valueOf(stdId));
        repository.delete(user);
        if (repository.findByStudentId(stdId) == null) {
            System.out.println(stdId + " removed");
        } else
            System.out.println();
    }
}
