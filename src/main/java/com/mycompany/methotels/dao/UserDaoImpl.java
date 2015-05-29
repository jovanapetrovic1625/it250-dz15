package com.mycompany.methotels.dao;

import com.mycompany.methotels.entities.City;
import com.mycompany.methotels.entities.User;
import java.util.List;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author JOVANA
 */
public class UserDaoImpl implements UserDao {

    @Inject
    private Session session;

    @Override
    public User checkUser(String email, String password) {
        try {
            User u = (User) session.createCriteria(User.class).add(Restrictions.eq("email",
                    email)).add(Restrictions.eq("sifra", password)).uniqueResult();
            if (u != null) {
                return u;
            }
            return null;
        } catch (NullPointerException e) {
            return null;
        }
    }

    @Override
    public User registerUser(User user) {
        return (User) session.merge(user);
    }

    @Override
    public boolean checkIfEmailExists(String email) {
        Long rows = (Long) session.createCriteria(User.class).add(Restrictions.eq("email",
                email)).setProjection(Projections.rowCount()).uniqueResult();
        return (rows == 0) ? false : true;
    }

    @Override
    public List<User> getAllUsersList() {
        return session.createCriteria(User.class).list();
    }

    @Override
    public User getUserById(Integer id) {
        System.out.println("Integer je " + id);
        return (User) session.createCriteria(User.class).add(Restrictions.eq("id", id)).uniqueResult();
    }

    @Override
    public void addUser(User user) {
        session.persist(user);
    }

    @Override
    public void deleteUser(Integer id) {
        User user = (User) session.createCriteria(User.class).add(Restrictions.eq("id", id)).uniqueResult();
        session.delete(user);
    }
}
