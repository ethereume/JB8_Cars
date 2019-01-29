package pl.cars;

import org.hibernate.SessionFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.cars.helpers.ConnectorDb;

@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        SessionFactory factory = ConnectorDb.getConnection();
        SpringApplication.run(Main.class, args);
    }
}
