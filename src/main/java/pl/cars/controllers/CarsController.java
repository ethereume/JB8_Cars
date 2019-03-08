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
        List<ObjectCars> lista = this.carsServices.getCarsList();
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
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd", Locale.ENGLISH);
        Date d = formatter.parse(pageName);
        this.carsServices.updateDataCar(id,d);
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void addCar(@RequestBody PersonalCar car){
        this.carsServices.saveCar(car);
    }


    @Autowired
    private ICarsServices carsServices;

    @Autowired
    private IJsonParser jsonparser;

}
