package pl.cars.model.Cars;

import javax.persistence.Entity;
import java.util.Date;

@Entity
public class PersonalCar extends ObjectCars {
    public PersonalCar() {}

    public PersonalCar(String name, CarsType typeOfCar, double price, Date data) {
        super(name, typeOfCar, price, data);
    }
}
