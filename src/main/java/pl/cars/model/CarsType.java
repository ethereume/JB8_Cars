package pl.cars.model;

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
    private String typeOfVehicle;
}
