package com.mycompany.methotels.rest;

import com.mycompany.methotels.dao.UserDao;
import com.mycompany.methotels.entities.User;
import java.util.List;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import org.apache.tapestry5.ioc.annotations.Inject;

/**
 *
 * @author JOVANA
 */
public class UserWebService implements UserWebServiceInterface {

    @Inject
    private UserDao userDao;

    @Override
    public List<User> getAll() {
        return (userDao.getAllUsersList());
    }

    @Override
    public User getUser(@PathParam("id") Integer id) {
        return userDao.getUserById(id);
    }

    @Override
    public Response post(User user) {
        userDao.addUser(user);
        return Response.ok().entity(user).build();
    }
}
