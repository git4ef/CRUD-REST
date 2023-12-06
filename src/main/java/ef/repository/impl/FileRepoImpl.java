package ef.repository.impl;

import ef.model.File;
import ef.repository.FileRepository;
import ef.util.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

public class FileRepoImpl implements FileRepository {
    @Override
    public File save(File file) {
        try (Session session = HibernateUtil.getSession()) {
            session.beginTransaction();
            File savedFile = session.merge(file);
            session.getTransaction().commit();
            return savedFile;
        }
    }

    @Override
    public File getById(Integer id) {
        try (Session session = HibernateUtil.getSession()) {
            return session.get(File.class, id);
        }
    }

    @Override
    public File update(File file) {
        try (Session session = HibernateUtil.getSession()) {
            session.beginTransaction();
            File updatedFile = session.merge(file);
            session.getTransaction().commit();
            return updatedFile;
        }
    }

    @Override
    public void deleteById(Integer id) {
        try (Session session = HibernateUtil.getSession()) {
            session.beginTransaction();
            File file = new File();
            file.setId(id);
            session.remove(file);
            session.getTransaction().commit();
        }
    }

    @Override
    public List<File> getAll() {
        try (Session session = HibernateUtil.getSession()) {
            session.beginTransaction();
            List<File> files = session.createQuery("FROM File", File.class).getResultList();
            session.getTransaction().commit();
            return files;
        }
    }
}
