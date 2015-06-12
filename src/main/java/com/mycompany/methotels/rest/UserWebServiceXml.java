package com.mycompany.methotels.rest;

import com.mycompany.methotels.dao.UserDao;
import com.mycompany.methotels.entities.User;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import org.apache.tapestry5.ioc.annotations.Inject;

/**
 *
 * @author JOVANA
 */
@Path("/userservicexml")
public class UserWebServiceXml {
    
    @Inject
    private UserDao userDao;
    
    @GET
    @Produces({"application/xml"})
    public List<User> getAll() {
        return (userDao.getAllUsersList());
    }
    
    @GET
    @Path("{id}")
    @Produces({"application/xml"})
    public User getUser(@PathParam("id") Integer id) {
        return userDao.getUserById(id);
    }
}
