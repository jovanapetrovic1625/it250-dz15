package com.mycompany.methotels.pages;

import com.mycompany.methotels.components.GenericEditor;
import com.mycompany.methotels.dao.UserDao;
import com.mycompany.methotels.entities.City;
import com.mycompany.methotels.entities.User;
import com.mycompany.methotels.services.ProtectedPage;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.security.RolesAllowed;
import org.apache.tapestry5.annotations.Component;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.hibernate.annotations.CommitAfter;
import org.apache.tapestry5.ioc.annotations.Inject;

/**
 *
 * @author JOVANA
 */
@ProtectedPage
@RolesAllowed(value={"Admin"})
public class AddUser {

    @Property
    private User user;

    @Property
    private User selecteduser;

    @Inject
    private UserDao userDao;

    @Property
    private List<User> userList;

    void onActivate() {
        if (userList == null) {
            userList = new ArrayList<User>();
        }
        userList = userDao.getAllUsersList();
        
    }

    @CommitAfter
    Object onSuccess() {
        userDao.addUser(user);
        return this;
    }

    @CommitAfter
    Object onActionFromDelete(int id) {
        userDao.deleteUser(id);
        return this;
    }
    
    @CommitAfter
    Object onActionFromEdit(User user) {
        this.user = user;
        return this;
    }
}
