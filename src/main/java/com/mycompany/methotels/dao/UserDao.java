package com.mycompany.methotels.dao;

import com.mycompany.methotels.entities.User;
import java.util.List;

/**
 *
 * @author JOVANA
 */
public interface UserDao {
        
    public List<User> getAllUsersList();

    public User getUserById(Integer id);

    public void addUser(User user);

    public void deleteUser(Integer id);
    
    public User checkUser(String email, String password);

    public User registerUser(User user);

    public boolean checkIfEmailExists(String email);
    
    public void addOrUpdateUser(User user);
       
}
