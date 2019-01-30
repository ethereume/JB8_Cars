package pl.cars;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.cars.helpers.ConnectorDb;
import pl.cars.model.CarsType;
import pl.cars.model.ObjectCars;
import pl.cars.model.Truck;

@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        SessionFactory factory = ConnectorDb.getConnection();
        Session s = factory.openSession();
        Transaction transaction = null;
        try{
            transaction = s.beginTransaction();
            ObjectCars t = new Truck();
            t.setName("Ciezarowka");
            t.setPrice(20000);
            t.setTypeOfCar(CarsType.TIRY);
            s.save(t);
            transaction.commit();
            System.out.println("Dodano do bazy !!");

        }catch (Exception e){
            if(transaction != null) transaction.rollback();
            System.out.println("Nie okreslony blad "+e.getMessage());
        } finally {
            s.close();
        }
        //SpringApplication.run(Main.class, args);
    }
}
