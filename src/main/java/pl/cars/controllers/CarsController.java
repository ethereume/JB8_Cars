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

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("api/cars")
public class CarsController {

    private ICarsServices carsServices;
    private IJsonParser jsonparser;

    public CarsController(ICarsServices carsServices, IJsonParser jsonparser) {
        this.carsServices = carsServices;
        this.jsonparser = jsonparser;
    }

    @GetMapping("/")
    public String index(){
        List<ObjectCars> lista = this.carsServices.getCarsList();
        Gson gson = new Gson();
        return gson.toJson(lista);
    }
    @GetMapping("/types")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String getTypesOfCar(){
        return jsonparser.generateTypeOfCar("Types",CarsType.getListOfCar());
    }

    @PutMapping("/car/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void indexUpdate(@PathVariable("id") int id){
        carsServices.updateCar(id);
    }

    @PutMapping("/data/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updateCarRend(@PathVariable("id") int id, @RequestBody String data) throws ParseException {
        System.out.println(id);
        System.out.println(data);
        JSONObject obj = new JSONObject(data);
        String pageName = obj.getString("data");
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd", Locale.ENGLISH);
        Date d = formatter.parse(pageName);
        this.carsServices.updateDataCar(id,d);
    }

    @PostMapping("/car/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ObjectCars getCar(@PathVariable int id){
        ObjectCars cars = this.carsServices.getSingeCar(id);
        return cars;
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void addCar(@RequestBody PersonalCar car){
        System.out.println(car);
        this.carsServices.saveCar(car);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String deletaCar(@PathVariable int id){
        this.carsServices.delete(id);
        Gson gson = new Gson();
        return gson.toJson("Usunieto");
    }
}
