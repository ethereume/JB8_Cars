package pl.cars.model.Cars;

import javax.persistence.Entity;
import java.util.Date;

@Entity
public class Machin extends ObjectCars {

    public Machin() {}

    public Machin(String name, CarsType typeOfCar, double price, Date data) {
        super(name, typeOfCar, price, data);
    }
}
