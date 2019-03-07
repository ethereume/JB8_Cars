package pl.cars.services;

import org.hibernate.type.DateType;
import pl.cars.model.Cars.CarsType;
import pl.cars.model.Cars.ObjectCars;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.List;

public interface ICarsServices {
    void delete(int id);
    List<ObjectCars> getCarsList();
    ObjectCars getSingeCar(int id);
    List<ObjectCars> getCarsByType(CarsType type);
    void updateCar(int id);
    void saveCar(ObjectCars c);
    void updateDataCar(int id, Date data);
}
