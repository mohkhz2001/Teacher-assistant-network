package com.mohkhz.tanetwork.Repository;

import com.mohkhz.tanetwork.Model.Entity.File;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @author Mohammad mehdi khajhezadeh
 * @project TA-network
 * @email_support eng.khajhezadeh@gmail.com
 * @create 21 October 2022 at 1:03 AM
 */
@Repository
public interface FileRepository extends JpaRepository<File, Long> {

    List<File> findAll();

    Optional<File> findById(Long id);

}
