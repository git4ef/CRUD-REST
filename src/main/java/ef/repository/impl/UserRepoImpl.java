package ef.repository.impl;


import ef.model.Event;
import ef.model.User;
import ef.repository.UserRepository;
import ef.util.HibernateUtil;
import org.hibernate.Session;


import java.util.List;

public class UserRepoImpl implements UserRepository {

    @Override
    public User save(User user) {
        try (Session session = HibernateUtil.getSession()) {
            session.beginTransaction();
            User savedUser = session.merge(user);
            session.getTransaction().commit();
            return savedUser;
        }
    }

    @Override
    public User getById(Integer id) {
        try (Session session = HibernateUtil.getSession()) {
            return session.createQuery("SELECT u FROM User u LEFT JOIN FETCH u.events WHERE u.id=:id", User.class)
                    .setParameter("id",id)
                    .getSingleResult();
        }
    }

    @Override
    public User update(User user) {
        try (Session session = HibernateUtil.getSession()) {
            session.beginTransaction();
            User updatedUser = session.merge(user);
            session.getTransaction().commit();
            return updatedUser;
        }
    }

    @Override
    public void deleteById(Integer id) {
        try (Session session = HibernateUtil.getSession()) {
            session.beginTransaction();
            User user = new User();
            user.setId(id);
            session.remove(user);
            session.getTransaction().commit();
        }
    }

    @Override
    public List<User> getAll() {
        try (Session session = HibernateUtil.getSession()) {
            session.beginTransaction();
            List<User> users = session.createQuery("SELECT u FROM User u LEFT JOIN FETCH u.events", User.class).getResultList();
            session.getTransaction().commit();
            return users;
        }
    }
}
