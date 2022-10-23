package com.mohkhz.tanetwork.Service;

import com.mohkhz.tanetwork.Model.Entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Mohammad mehdi khajhezadeh
 * @project TA-network
 * @email_support eng.khajhezadeh@gmail.com
 * @create 21 October 2022 at 1:05 AM
 */
@Service
public interface UserService {

    User findByStudentId(String studentId);

    User findByPhoneNumber(Long phoneNumber);

    User newUser(User user);

    List<User> getAll();

    User newUserAdmin(User user);

    void deleteUser(Long stdId);

}
