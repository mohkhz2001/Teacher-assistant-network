package com.mohkhz.tanetwork.Impl;

import com.mohkhz.tanetwork.Model.Entity.File;
import com.mohkhz.tanetwork.Repository.FileRepository;
import com.mohkhz.tanetwork.Service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Mohammad mehdi khajhezadeh
 * @project TA-network
 * @email_support eng.khajhezadeh@gmail.com
 * @create 21 October 2022 at 1:06 AM
 */
@Service
public class FileImplementation implements FileService {

    @Autowired
    FileRepository repository;

    @Override
    public List<File> getAll() {
        return repository.findAll();
    }

    @Override
    public File getById(Long id) {
        return repository.findById(id).orElse(new File());
    }

    @Override
    public File addNewFile(File file) {
        return repository.save(file);
    }

    @Override
    public void deleteFile(Long fId) {
        repository.delete(getById(fId));
    }
}
