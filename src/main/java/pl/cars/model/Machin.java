package pl.cars.model;

import javax.persistence.Entity;

@Entity
public class Machin extends ObjectCars {

    public Machin() {}

    public Machin(String name, CarsType typeOfCar, double price) {
        super(name, typeOfCar, price);
    }

}
