package pl.cars.model.Cars;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tCars")
public  abstract class ObjectCars implements Cars {

    protected ObjectCars() {}

    protected ObjectCars(String name, CarsType typeOfCar, double price, Date data) {
        this.name = name;
        this.typeOfCar = typeOfCar;
        this.price = price;
        this.data = data;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", typeOfCar=" + typeOfCar +
                ", price=" + price +
                ", data=" + data +
                '}';
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "carsName")
    protected String name;

    @Column(name = "typeOfCar")
    protected CarsType typeOfCar;

    @Column(name = "price")
    protected double price;
    @Column(name = "DateOfRend")
    protected Date  data;
}
