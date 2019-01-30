package pl.cars.services;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import pl.cars.helpers.ConnectorDb;
import pl.cars.model.Cars;
import pl.cars.model.CarsType;
import pl.cars.model.ObjectCars;

import java.util.List;

@Controller
public class CarsServicesImpl implements ICarsServices {


    @Override
    public ObjectCars getCars() {
        return null;
    }

    @Override
    public List<ObjectCars> getCarsList() {
        return null;
    }

    @Override
    public ObjectCars getSingeCar(int id) {
        return null;
    }

    @Override
    public List<ObjectCars> getCarsByType(CarsType type) {
        return null;
    }

    @Override
    public void updateCar(int id) {

    }

    @Override
    public void saveCar(ObjectCars c) {
            this.doQueryToDb(c);
    }
    private void doQueryToDb(ObjectCars c){
        SessionFactory sf = ConnectorDb.getConnection();
        Session s  = sf.openSession();
        Transaction transaction = null;
        try{
            transaction = s.beginTransaction();
            s.save(c);
            transaction.commit();
            System.out.println("Make query ");

        }catch (Exception e){
            if(transaction != null) transaction.rollback();
            System.out.println("Some error, looks at logs "+e.getMessage());
        } finally {
            s.close();
        }
    }

    @Autowired
    private SessionFactory dbConnection;
}
