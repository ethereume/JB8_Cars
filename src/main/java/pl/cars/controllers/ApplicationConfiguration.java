package pl.cars.controllers;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import pl.cars.helpers.ConnectorDb;
import pl.cars.services.CarsServicesImpl;
import pl.cars.services.ICarsServices;

@Configuration
@ComponentScan("pl.cars.services")
public class ApplicationConfiguration {

    @Bean
    public SessionFactory getDbConnection(){
        return ConnectorDb.getConnection();
    }
}
