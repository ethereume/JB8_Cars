package pl.cars.controllers;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.cars.model.Users.User;
import pl.cars.services.IJsonParser;
import pl.cars.services.IUserServices;
import pl.cars.services.JsonaParser;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@Controller
@RequestMapping("api/user")
public class AdminController {

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    @ResponseBody
    public String index(@RequestParam() String login,String password){
        if(login.equals("") || password.equals("")){
            return jsonaParser.generateErrorObject("Twoje dane sa puste. Prosze podać je poprawnie !!");
        }
        User tmp = services.getUser(login,password);
        if(tmp == null){
            return jsonaParser.generateErrorObject("Nie ma takiego użytkownika. Zarejestruj się !!");
        } else {
            return jsonaParser.generateOkObject("Witaj użytkowniku",tmp);
        }
    }

    @Autowired
    private IUserServices services;
    @Autowired
    private IJsonParser jsonaParser;
}
