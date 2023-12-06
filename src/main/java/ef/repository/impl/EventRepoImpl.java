package ef.repository.impl;

import ef.model.Event;
import ef.model.User;
import ef.repository.EventRepository;
import ef.util.HibernateUtil;
import jakarta.transaction.Transactional;
import org.hibernate.Session;

import java.util.List;

public class EventRepoImpl implements EventRepository {
    @Override
    public Event save(Event event) {
        try (Session session = HibernateUtil.getSession()) {
            session.beginTransaction();
            Event savedEvent = session.merge(event);
            session.getTransaction().commit();
            return savedEvent;
        }
    }

    @Override
    public Event getById(Integer id) {
        try (Session session = HibernateUtil.getSession()) {
            return session.createQuery("SELECT e FROM Event e LEFT JOIN FETCH e.user LEFT JOIN FETCH e.file WHERE e.id=:id", Event.class)
                    .setParameter("id",id)
                    .getSingleResult();
        }
    }

    @Override
    public Event update(Event event) {
        try (Session session = HibernateUtil.getSession()) {
            session.beginTransaction();
            Event updatedEvent = session.merge(event);
            session.getTransaction().commit();
            return updatedEvent;
        }
    }

    @Override
    public void deleteById(Integer id) {
        try (Session session = HibernateUtil.getSession()) {
            session.beginTransaction();
            Event event = new Event();
            event.setId(id);
            session.remove(event);
            session.getTransaction().commit();
        }
    }

    @Override
    public List<Event> getAll() {
        try (Session session = HibernateUtil.getSession()) {
            session.beginTransaction();
            List<Event> events = session.createQuery("SELECT e FROM Event e LEFT JOIN FETCH e.user LEFT JOIN FETCH e.file", Event.class).getResultList();
            return events;
        }
    }
}
