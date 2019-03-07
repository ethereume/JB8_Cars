package pl.cars.services;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import pl.cars.model.Cars.CarsType;
import pl.cars.model.Cars.ObjectCars;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
public class CarsServicesImpl implements ICarsServices {


    @Override
    public void delete(int id) {
        Optional<ObjectCars> cars = this.getElementById(id);
        if(cars.isPresent()){
            this.doQueryToDb(cars.get(),TypeOfQuery.DELETE);
        }
    }

    @Override
    public List<ObjectCars> getCarsList() {
        Session s = dbConnection.openSession();
        Transaction t = null;

        try {
            t = s.beginTransaction();
            List<ObjectCars> list = s.createCriteria(ObjectCars.class).list();
            t.commit();
            return list;
        }catch (Exception e) {
            if(t != null) t.rollback();
        } finally {
            s.close();
        }
        return null;
    }

    @Override
    public ObjectCars getSingeCar(int id) {
        return this.getElementById(id).get();
    }

    @Override
    public List<ObjectCars> getCarsByType(CarsType type) {
        return null;
    }

    @Override
    public void updateCar(int id) {
        Optional<ObjectCars> cars = this.getElementById(id);
        if(cars.isPresent()){
            cars.get().setId(id);
            cars.get().setName("Dudus");
            this.doQueryToDb(cars.get(),TypeOfQuery.UPDATE);
        }
    }

    @Override
    public void saveCar(ObjectCars c) {
            this.doQueryToDb(c,TypeOfQuery.INSERT);
    }

    @Override
    public void updateDataCar(int id, Date data) {
        Optional<ObjectCars> cars = getElementById(id);
        if(cars.isPresent()){
            cars.get().setData(data);
            doQueryToDb(cars.get(),TypeOfQuery.UPDATE);
        }
    }

    private void doQueryToDb(ObjectCars c,TypeOfQuery type){
        Session s  = dbConnection.openSession();
        Transaction transaction = null;
        try{
            transaction = s.beginTransaction();
            switch (type){
                case DELETE:
                    s.delete(c);
                    break;
                case INSERT:
                    s.save(c);
                    break;
                case UPDATE:
                    s.update(c);
                    break;
            }
            transaction.commit();
            System.out.println("Make query of type "+type.getName()+" at object "+c.getCarsType());

        } catch (Exception e){
            if(transaction != null) transaction.rollback();
            System.out.println("Some error, looks at logs "+e.getMessage());
        } finally {
            s.close();
        }
    }
    private Optional<ObjectCars> getElementById(int id) {
        Session s = dbConnection.openSession();
        Transaction t = s.beginTransaction();
        try {

             ObjectCars cars = (ObjectCars) s.get(ObjectCars.class, id);
            Optional<ObjectCars> tmp = new Optional<>(cars);
            t.commit();
            return tmp;
        }catch (Exception e) {
            if (t != null) t.rollback();
        } finally {
            s.close();
        }
        return null;
    }

    private enum TypeOfQuery {
        INSERT("Insert"),
        UPDATE("Update"),
        DELETE("Delete");

        TypeOfQuery(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        private String name;
    }

    @Autowired
    private SessionFactory dbConnection;
}
