package pl.cars.model.Cars;

import javax.persistence.Entity;
import java.util.Date;

@Entity
public class Truck extends ObjectCars {
    public Truck() {}

    public Truck(String name, CarsType typeOfCar, double price, Date data) {
        super(name, typeOfCar, price, data);
    }
}
