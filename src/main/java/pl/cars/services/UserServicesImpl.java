package pl.cars.services;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import pl.cars.model.Users.User;

@Controller
public class UserServicesImpl implements IUserServices {
    @Override
    public User getUser(String name, String password) {
        Session s = dbConnection.openSession();
        Transaction t = s.beginTransaction();
        User tmp = null;
        try {
            Criteria m = s.createCriteria(User.class);
            m.add(Restrictions.eq("id",id));
            Animal mm = (Animal) m.uniqueResult();
        }catch (Exception e) {
            if(s != null) t.rollback();
        }finally {
             s.close();
        }
        return tmp;
    }

    @Override
    public void addUser(String name, String password) {

    }

    @Override
    public void login(boolean login) {

    }

    @Override
    public void logout(boolean logout) {

    }
    @Autowired
    private SessionFactory dbConnection;
}
