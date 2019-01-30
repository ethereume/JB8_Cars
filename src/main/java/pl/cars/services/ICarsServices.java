package pl.cars.services;

import pl.cars.model.Cars;
import pl.cars.model.CarsType;
import pl.cars.model.ObjectCars;

import java.util.List;

public interface ICarsServices {
    ObjectCars getCars();
    List<ObjectCars> getCarsList();
    ObjectCars getSingeCar(int id);
    List<ObjectCars> getCarsByType(CarsType type);
    void updateCar(int id);
    void saveCar(ObjectCars c);
}
