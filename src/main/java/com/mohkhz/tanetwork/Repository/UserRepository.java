package com.mohkhz.tanetwork.Repository;

import com.mohkhz.tanetwork.Model.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Mohammad mehdi khajhezadeh
 * @project TA-network
 * @email_support eng.khajhezadeh@gmail.com
 * @create 21 October 2022 at 12:52 AM
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByStudentId(Long studentId);

    User findByPhoneNumber(Long phoneNumber);


}
