package com.mohkhz.tanetwork.Service;

import com.mohkhz.tanetwork.Model.Entity.File;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Mohammad mehdi khajhezadeh
 * @project TA-network
 * @email_support eng.khajhezadeh@gmail.com
 * @create 21 October 2022 at 1:05 AM
 */
@Service
public interface FileService {

    List<File> getAll();

    File getById(Long id);

    File addNewFile(File file);

    void deleteFile(Long fId);

}
