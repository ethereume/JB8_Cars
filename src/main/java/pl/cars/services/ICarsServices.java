package pl.cars.services;

import pl.cars.model.Cars.CarsType;
import pl.cars.model.Cars.ObjectCars;

import java.util.List;

public interface ICarsServices {
    void delete(int id);
    List<ObjectCars> getCarsList();
    ObjectCars getSingeCar(int id);
    List<ObjectCars> getCarsByType(CarsType type);
    void updateCar(int id);
    void saveCar(ObjectCars c);
}
