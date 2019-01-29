package pl.cars.services;

import pl.cars.model.Cars;
import pl.cars.model.CarsType;

import java.util.List;

public interface ICarsServices {
    Cars getCars();
    List<Cars> getCarsList();
    Cars getSingeCar(int id);
    Cars getCarsByType(CarsType type);
    void updateCar(int id);
}
