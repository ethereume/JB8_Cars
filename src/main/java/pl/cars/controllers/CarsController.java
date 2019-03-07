package pl.cars.controllers;

import com.google.gson.Gson;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.cars.model.Cars.CarsType;
import pl.cars.model.Cars.ObjectCars;
import pl.cars.model.Cars.PersonalCar;
import pl.cars.services.ICarsServices;
import pl.cars.services.IJsonParser;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/*@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)*/
@CrossOrigin
@Controller
@RequestMapping("api/cars")
public class CarsController {

    @RequestMapping(value = "/", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public String index(){
        ObjectCars a = new PersonalCar("Opel Zefira", CarsType.SEDAN,4532,new Date());
        ObjectCars c = new PersonalCar("Opel Corsa", CarsType.KABRIO,3243,new Date());
        ObjectCars d = new PersonalCar("BMW", CarsType.KABRIO,3243,new Date());
        ObjectCars e = new PersonalCar("Nissan Micra", CarsType.KABRIO,3243,new Date());
        ObjectCars f = new PersonalCar("Grand Virata", CarsType.KABRIO,3243,new Date());
        ObjectCars g = new PersonalCar("Suzuki Jimmy", CarsType.KABRIO,3243,new Date());
        List lista = new ArrayList();
        lista.add(a);
        lista.add(c);
        lista.add(d);
        lista.add(e);
        lista.add(f);
        lista.add(g);
        this.carsServices.saveCar(a);
        this.carsServices.saveCar(c);
        this.carsServices.saveCar(d);
        this.carsServices.saveCar(e);
        this.carsServices.saveCar(f);
        this.carsServices.saveCar(g);
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
    @PostMapping("/data/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updateCarRend(@PathVariable("id") int id, @RequestBody String data) throws ParseException {
        JSONObject obj = new JSONObject(data);
        String pageName = obj.getString("data");
        SimpleDateFormat formatter = new SimpleDateFormat("E, MMM dd yyyy HH:mm:ss", Locale.ENGLISH);
        Date d = formatter.parse(pageName);
        this.carsServices.updateDataCar(id,d);
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void addCar(@RequestBody PersonalCar car){
        this.carsServices.saveCar(car);
        /*
        "name":"Opel Astra",
        "typeOfCar":"OSOBOWE",
        "price":"2000.00",
        "data":"2018-03-07"
        * */

    }


    @Autowired
    private ICarsServices carsServices;

    @Autowired
    private IJsonParser jsonparser;

}
