package com.mycompany.methotels.pages;

import com.mycompany.methotels.dao.UserDao;
import com.mycompany.methotels.entities.User;
import java.util.List;
import org.apache.tapestry5.ComponentResources;
import org.apache.tapestry5.annotations.OnEvent;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.hibernate.annotations.CommitAfter;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.ajax.AjaxResponseRenderer;
import org.got5.tapestry5.jquery.components.InPlaceEditor;

/**
 *
 * @author JOVANA
 */
public class InPlaceEditorExample {

    @Property
    private User user;
    @Property
    private List<User> userList;
    @Inject
    private AjaxResponseRenderer ajaxResponseRenderer;
    @Inject
    private UserDao userDao;
    @Inject
    private ComponentResources _componentResources;

    void onActivate() {
        userList = userDao.getAllUsersList();
    }

    @CommitAfter
    @OnEvent(component = "userEmail", value = InPlaceEditor.SAVE_EVENT)
    void setImeDrzave(Long id, String value) {
        User user = (User) userDao.getUserById(id.intValue());
        user.setEmail(value);
        System.out.println("Email saved");
        userDao.addOrUpdateUser(user);
    }
}
