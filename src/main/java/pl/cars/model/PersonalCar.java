package pl.cars.model;

import javax.persistence.Entity;

@Entity
public class PersonalCar extends ObjectCars {
    public PersonalCar() {}

    public PersonalCar(String name, CarsType typeOfCar, double price) {
        super(name, typeOfCar, price);
    }
}
