package com.mycompany.methotels.rest;

import com.mycompany.methotels.entities.User;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import org.apache.tapestry5.hibernate.annotations.CommitAfter;


/**
 *
 * @author JOVANA
 */
@Path("/userservice")
public interface UserWebServiceInterface {

    @GET
    @Produces({"application/json"})
    public List<User> getAll();

    @GET
    @Path("{id}")
    @Produces({"application/json"})
    public User getUser(@PathParam("id") Integer id);

    @POST
    @CommitAfter
    @Produces({"application/json"})
    @Consumes({"application/json"})
    public Response post(User user);
}
