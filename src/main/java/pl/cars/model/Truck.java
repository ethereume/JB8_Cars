package pl.cars.model;

import javax.persistence.Entity;

@Entity
public class Truck extends ObjectCars {
    public Truck() {}

    public Truck(String name, CarsType typeOfCar, double price) {
        super(name, typeOfCar, price);
    }
}
