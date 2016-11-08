package eugene.spring.service;

import java.util.List;
import eugene.spring.dao.UserDAO;
import eugene.spring.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Aspire on 05.11.2016.
 */
@Service
public class UserServiceImpl implements UserService{
    private UserDAO userDAO;

    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Transactional
    public void addUser(User u) {
        this.userDAO.addUser(u);
    }

    @Transactional
    public void updateUser(User u) {
        this.userDAO.updateUser(u);
    }

    @Transactional
    public List<User> listUsers(String name) {
        return this.userDAO.listUsers(name);
    }

    @Transactional
    public User getUserById(int id) {
        return this.userDAO.getUserById(id);
    }

    @Transactional
    public void removeUser(int id) {
        this.userDAO.removeUser(id);
    }
}
