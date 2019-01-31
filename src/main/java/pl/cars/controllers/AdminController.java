package pl.cars.controllers;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.cars.model.Users.User;
import pl.cars.services.IJsonParser;
import pl.cars.services.IUserServices;
import pl.cars.services.JsonaParser;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

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
    @RequestMapping(value = "/login",method = RequestMethod.POST,headers="Content-Type=application/json")
    @ResponseBody
    public String indexRejest(@RequestBody String parameter) {
        User g = jsonaParser.parseUser(parameter);
        if(g.getName().equals("") || g.getPassword().equals("")){
            return jsonaParser.generateErrorObject("Twoje dane sa puste. Prosze podać je poprawnie !!");
        }
        User tmp = null;
            try {
                tmp = services.getUser(g.getName(),g.getPassword());
            } catch (NullPointerException e){
            }
            if(tmp != null){
                return jsonaParser.generateErrorObject("Użytkownik o takim loginie "+tmp.getName()+" istnieje. Podaj nowego");
            }
        g.setLogged(true);
        g.setAddDate(new Date());
        services.addUser(g);
        return jsonaParser.generateOkObject("Witaj nowy użytkowniku",g);
    }

    @Autowired
    private IUserServices services;
    @Autowired
    private IJsonParser jsonaParser;
}
