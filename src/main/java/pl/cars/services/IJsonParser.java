package pl.cars.services;

import pl.cars.model.Cars.Cars;
import pl.cars.model.Cars.ObjectCars;
import pl.cars.model.Users.User;

import java.util.List;

public interface IJsonParser {
    String generateErrorObjectForUser(String error);
    String generateOkObjectForUser(String message, User u);
    User parseUser(String obje);
    ObjectCars parseCar(String obj);
    String generateErrorObjectForCar(String error);
    String generateOkObjectForCar(String message, ObjectCars c);
    String generateCarsList(String message, List<ObjectCars> c);
}
