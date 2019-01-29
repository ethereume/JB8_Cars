package pl.cars.model;

import javax.persistence.*;

@Entity(name = "car")
public  class  ObjectCars implements Cars {

    public ObjectCars() {}

    public ObjectCars(String name, CarsType typeOfCar, double price) {
        this.name = name;
        this.typeOfCar = typeOfCar;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public CarsType getTypeOfCar() {
        return typeOfCar;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTypeOfCar(CarsType typeOfCar) {
        this.typeOfCar = typeOfCar;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    @Override
    public String getCarsType() {
        return typeOfCar.getTypeOfVehicle();
    }
    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String getFullName() {
        return "{" +
                "name:'" + name + '\'' +
                ", typeOfCar:" + typeOfCar +
                ", price:" + price +
                '}';
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    protected String name;
    protected CarsType typeOfCar;
    protected double price;
}
