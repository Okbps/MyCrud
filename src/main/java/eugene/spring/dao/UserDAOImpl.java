package eugene.spring.dao;

import eugene.spring.model.User;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
/**
 * Created by Aspire on 05.11.2016.
 */

@Repository
public class UserDAOImpl implements UserDAO{

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }

    public void addUser(User u) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(u);
    }

    public void updateUser(User u) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(u);
    }

    @SuppressWarnings("unchecked")
    public List<User> listUsers(String name) {
        Session session = this.sessionFactory.getCurrentSession();
        String query = "from User u";
        if(name!=null
                //&& !name.isEmpty()
                ) query += " where u.name = '"+name+"'";
        List<User> usersList = session.createQuery(query).list();
        return usersList;
    }

    public User getUserById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        User u = (User) session.load(User.class, new Integer(id));
        return u;
    }

    public void removeUser(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        User u = (User) session.load(User.class, new Integer(id));
        if(u != null){
            session.delete(u);
        }
    }
}
