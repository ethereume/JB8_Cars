package pl.cars;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import pl.cars.controllers.ApplicationConfiguration;
import pl.cars.controllers.SiteController;
import pl.cars.helpers.ConnectorDb;
import pl.cars.model.CarsType;
import pl.cars.model.ObjectCars;
import pl.cars.model.PersonalCar;
import pl.cars.model.Truck;
import pl.cars.services.CarsServicesImpl;
import pl.cars.services.ICarsServices;

@SpringBootApplication
public class Main {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
        SpringApplication.run(Main.class, args);
    }
}
