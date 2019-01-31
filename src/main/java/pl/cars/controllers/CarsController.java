package pl.cars.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.cars.model.Cars.CarsType;
import pl.cars.model.Cars.ObjectCars;
import pl.cars.model.Cars.PersonalCar;
import pl.cars.services.ICarsServices;
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@Controller
@RequestMapping("api/cars")
public class CarsController {

    @RequestMapping(value = "/", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public String index(){
        ObjectCars b = new PersonalCar("Opel Zefira", CarsType.SEDAN,4532);
        ObjectCars c = new PersonalCar("Opel Corsa", CarsType.KABRIO,3243);
        carsServices.saveCar(b);
        carsServices.saveCar(c);
        return "Add object "+b.toString();
    }
    @RequestMapping(value = "/cars/{id}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public String indexUpdate(@PathVariable("id") int id){
        carsServices.updateCar(id);
        return "Update car "+id;
    }
    @RequestMapping(value = "/car/{id}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public String indexGetOneCar(@PathVariable("id") int id){
        return "Get car "+carsServices.getSingeCar(id).toString();
    }
    @RequestMapping(value = "/allCars", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public String indexGetOneCar(){
        return "CarsList "+carsServices.getCarsList().toString();
    }
    @Autowired
    private ICarsServices carsServices;

}
