package eugene.spring.dao;

import eugene.spring.model.User;

import java.util.List;

/**
 * Created by Aspire on 05.11.2016.
 */
public interface UserDAO {
    public void addUser(User u);
    public void updateUser(User u);
    public List<User> listUsers(String name);
    public User getUserById(int id);
    public void removeUser(int id);
}
