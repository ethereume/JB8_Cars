package pl.cars.controllers;

import com.fasterxml.jackson.databind.util.JSONPObject;
import jdk.nashorn.internal.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.cars.services.CarsServicesImpl;
import pl.cars.services.ICarsServices;

import java.util.Collections;
import java.util.Map;

@Controller
public class SiteController {

    @RequestMapping(value = "/", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public String index(){

        return "Hello World";
    }

  /*  @Autowired
    private CarsServicesImpl carsServices;*/

}
