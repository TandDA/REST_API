package org.rest.repository.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.rest.model.Event;
import org.rest.model.File;
import org.rest.repository.EventRepository;

import java.util.List;
import java.util.Set;

public class EventRepositoryImpl implements EventRepository {
    SessionFactory sessionFactory = HibernateContext.getSession();
    @Override
    public Event getById(Integer id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Event result = session.get(Event.class,id);
        transaction.commit();
        session.close();
        return result;
    }

    @Override
    public Set<Event> getAll() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Set<Event> result = (Set<Event>) session.createQuery("FROM Event").list();
        transaction.commit();
        session.close();
        return result;
    }

    @Override
    public Event save(Event event) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(event);
        transaction.commit();
        session.close();
        return event;
    }

    @Override
    public Event update(Event newEvent) {
        Event eventToUpdate = null;
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        eventToUpdate = session.get(Event.class, newEvent.getId());
        eventToUpdate.setUser(newEvent.getUser());
        eventToUpdate.setFile(newEvent.getFile());
        session.update(eventToUpdate);
        transaction.commit();

        session.close();

        return eventToUpdate;
    }

    @Override
    public void deleteById(Integer id) {
        Event eventToDelete = null;
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        eventToDelete = session.get(Event.class, id);
        session.delete(eventToDelete);
        transaction.commit();
        session.close();
    }
}
