package pl.cars.services;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import pl.cars.model.Cars.ObjectCars;
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
            m.add(Restrictions.eq("NAME",name));
            m.add(Restrictions.eq("PASSWORD",password));
            tmp = (User) m.uniqueResult();
            t.commit();
        }catch (Exception e) {
            if(s != null) t.rollback();
        }finally {
             s.close();
        }
        return tmp;
    }

    @Override
    public void addUser(User u) {
        Session s = dbConnection.openSession();
        Transaction t = s.beginTransaction();
        try {
            s.save(u);
        }catch (Exception e){
            if(t != null) t.rollback();
        }finally {
            s.close();
        }
    }

    @Override
    public void loginAndLogOut(User u,boolean login) {
        Session s = dbConnection.openSession();
        Transaction t = s.beginTransaction();
        try {
            User ty = this.getSingleUser(u.getId());
            if(login) {
                ty.setLogged(true);
            } else {
                ty.setLogged(false);
            }
            s.update(u);
        }catch (Exception e){
            if(t != null) t.rollback();
        }finally {
            s.close();
        }
    }

    @Override
    public User getSingleUser(int id) {
        Session s = dbConnection.openSession();
        Transaction t = s.beginTransaction();
        User u = null;
        try {
            u = (User) s.get(User.class, id);
            t.commit();

        }catch (Exception e) {
            if (t != null) t.rollback();
        } finally {
            s.close();
        }
    return u;
    }

    @Autowired
    private SessionFactory dbConnection;
}
