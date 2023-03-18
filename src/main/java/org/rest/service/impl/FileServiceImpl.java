package org.rest.service.impl;

import org.rest.model.File;
import org.rest.repository.FileRepository;
import org.rest.repository.hibernate.FileRepositoryImpl;
import org.rest.service.FileService;

import java.util.Set;

public class FileServiceImpl implements FileService {
    FileRepositoryImpl fileRepository = new FileRepositoryImpl();
    @Override
    public File getById(Integer integer) {
        return fileRepository.getById(integer);
    }

    @Override
    public Set<File> getAll() {
        return fileRepository.getAll();
    }

    @Override
    public File save(File file) {
        return fileRepository.save(file);
    }

    @Override
    public File update(File file) {
        return fileRepository.update(file);
    }

    @Override
    public void deleteById(Integer integer) {
        fileRepository.deleteById(integer);
    }
}
