package org.rest.repository.hibernate;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.rest.model.Event;
import org.rest.model.File;
import org.rest.repository.FileRepository;

import java.util.Set;

public class FileRepositoryImpl implements FileRepository {
    SessionFactory sessionFactory = HibernateContext.getSession();
    @Override
    public File getById(Integer id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        File result = session.get(File.class,id);
        transaction.commit();
        session.close();
        return result;
    }

    @Override
    public Set<File> getAll() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Set<File> result = (Set<File>) session.createQuery("FROM File").list();
        transaction.commit();
        session.close();
        return result;
    }

    @Override
    public File save(File file) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(file);
        transaction.commit();
        session.close();
        return file;
    }

    @Override
    public File update(File newFile) {
        File fileToUpdate = null;
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        fileToUpdate = session.get(File.class, newFile.getId());
        fileToUpdate.setFilePath(newFile.getFilePath());
        fileToUpdate.setName(newFile.getName());
        session.update(fileToUpdate);
        transaction.commit();

        session.close();

        return fileToUpdate;
    }

    @Override
    public void deleteById(Integer id) {
        File fileToDelete = null;
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        fileToDelete = session.get(File.class, id);
        session.delete(fileToDelete);
        transaction.commit();
        session.close();
    }
}
