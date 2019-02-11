package pl.cars.model.Cars;

import java.util.ArrayList;
import java.util.List;

public enum CarsType {
    OSOBOWE("Osobowe"),
	SEDAN("Sedan"),
	KABRIO("Kabrio"),
	KOMBI("Kombi"),
	SUV("Suv"),
	BUSY("Busy"),
	TIRY("Tiry"),
	KOPARKI("Koparki"),
	WALCE("Walce"),
	DŹWIGI("Dźwigi");

    CarsType(String type) {
        this.typeOfVehicle = type;
    }
    public String getTypeOfVehicle() {
        return typeOfVehicle;
    }
    public static List<String> getListOfCar(){
    	List<String> lista = new ArrayList<>();
		CarsType[] g = CarsType.class.getEnumConstants();
		for (int i = 0; i < g.length; i++) {
			lista.add(g[i].getTypeOfVehicle());
		}
		return lista;
	}
    private String typeOfVehicle;
}
