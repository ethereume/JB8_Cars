package pl.cars.model;

import javax.persistence.*;

@Entity
@Table(name = "tCars")
public  abstract class ObjectCars implements Cars {

    protected ObjectCars() {}

    protected ObjectCars(String name, CarsType typeOfCar, double price) {
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
    @Column(name = "CARS_ID")
    private int id;

    @Column(name = "CARS_NAME")
    protected String name;

    @Column(name = "TYPE_OF_CAR")
    protected CarsType typeOfCar;

    @Column(name = "PRICE")
    protected double price;
}
