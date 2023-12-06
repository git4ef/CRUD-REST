package ef.service;

import ef.model.File;

import ef.repository.FileRepository;
import ef.repository.impl.FileRepoImpl;

import java.util.List;

public class FileService {
    private FileRepository fileRepository = new FileRepoImpl();

    public File getFileByID(Integer id) {
        return fileRepository.getById(id);
    }

    public void deletePostByID(Integer id) {
        fileRepository.deleteById(id);
    }

    public File saveFile(File file) {
        return fileRepository.save(file);
    }

    public File updateFile(File file) {
        return fileRepository.update(file);
    }

    public List<File> getAllFiles() {
        return fileRepository.getAll();
    }
}
