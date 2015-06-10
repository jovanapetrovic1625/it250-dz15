package com.mycompany.methotels.pages;

import com.mycompany.methotels.dao.UserDao;
import com.mycompany.methotels.entities.User;
import java.util.List;
import org.apache.tapestry5.annotations.InjectComponent;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.corelib.components.Zone;
import org.apache.tapestry5.hibernate.annotations.CommitAfter;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.Request;
import org.apache.tapestry5.services.ajax.AjaxResponseRenderer;

/**
 *
 * @author JOVANA
 */
public class AjaxGridRefreshUser {

    @Inject
    private UserDao userDao;
    @Property
    @Persist
    private User user;
    @Property
    private User selecteduser;
    @Property
    private List<User> userList;
    @InjectComponent
    private Zone zoneUser;
    @InjectComponent
    private Zone formZone;
    @Inject
    private Request request;
    @Inject
    private AjaxResponseRenderer ajaxResponseRenderer;

    void onActivate() {
        userList = userDao.getAllUsersList();
    }

    @CommitAfter
    Object onSuccess() {
        userDao.addOrUpdateUser(user);
        userList = userDao.getAllUsersList();
        user = new User();
        if (request.isXHR()) {
            ajaxResponseRenderer.addRender(zoneUser).addRender(formZone);
        }
        return request.isXHR() ? zoneUser.getBody() : null;
    }

    @CommitAfter
    Object onActionFromDelete(int id) {
        userDao.deleteUser(id);
        userList = userDao.getAllUsersList();
        return request.isXHR() ? zoneUser.getBody() : null;
    }

    @CommitAfter
    Object onActionFromEdit(User toEdit) {
        user = toEdit;
        return request.isXHR() ? formZone.getBody() : null;
    }
}
