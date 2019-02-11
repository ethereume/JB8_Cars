package pl.cars.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.cars.model.Cars.CarsType;
import pl.cars.model.Cars.ObjectCars;
import pl.cars.model.Cars.PersonalCar;
import pl.cars.services.ICarsServices;
import pl.cars.services.IJsonParser;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@Controller
@RequestMapping("api/cars")
public class CarsController {

    @RequestMapping(value = "/", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public String index(){
        ObjectCars a = new PersonalCar("Opel Zefira", CarsType.SEDAN,4532);
        ObjectCars c = new PersonalCar("Opel Corsa", CarsType.KABRIO,3243);
        ObjectCars d = new PersonalCar("BMW", CarsType.KABRIO,3243);
        ObjectCars e = new PersonalCar("Nissan Micra", CarsType.KABRIO,3243);
        ObjectCars f = new PersonalCar("Grand Virata", CarsType.KABRIO,3243);
        ObjectCars g = new PersonalCar("Suzuki Jimmy", CarsType.KABRIO,3243);
        List lista = new ArrayList();
        lista.add(a);
        lista.add(c);
        lista.add(d);
        lista.add(e);
        lista.add(f);
        lista.add(g);
        return jsonparser.generateCarsList("Cars",lista);
    }

    @RequestMapping(value = "/types",method = RequestMethod.GET,produces = "application/json")
    @ResponseBody
    public String getTypesOfCar(){
        return jsonparser.generateTypeOfCar("Types",CarsType.getListOfCar());
    }


    @RequestMapping(value = "/cars/{id}", method = RequestMethod.POST, produces = "application/json")
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

    @Autowired
    private IJsonParser jsonparser;

}
