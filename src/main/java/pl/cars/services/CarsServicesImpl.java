package pl.cars.services;

import org.hibernate.SessionFactory;
import pl.cars.helpers.ConnectorDb;
import pl.cars.model.Cars;
import pl.cars.model.CarsType;

import java.util.List;

public class CarsServicesImpl implements ICarsServices {


    @Override
    public Cars getCars() {
        return null;
    }

    @Override
    public List<Cars> getCarsList() {
        return null;
    }

    @Override
    public Cars getSingeCar(int id) {
        return null;
    }

    @Override
    public Cars getCarsByType(CarsType type) {
        return null;
    }

    @Override
    public void updateCar(int id) {

    }
    /*private SessionFactory factory = ConnectorDb.getConnection();*/
}
