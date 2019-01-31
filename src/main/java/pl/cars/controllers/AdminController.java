package pl.cars.controllers;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.cars.model.Users.User;
import pl.cars.services.IJsonParser;
import pl.cars.services.IUserServices;
import pl.cars.services.JsonaParser;

import javax.servlet.http.HttpServletRequest;
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
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public String indexRejest(@RequestParam() HttpServletRequest request) {
        if(request.getParameter("login").equals("") ||
                request.getParameter("password").equals("") ||
                Boolean.parseBoolean(request.getParameter("admin")) ){
            return jsonaParser.generateErrorObject("Twoje dane sa puste. Prosze podać je poprawnie !!");
        }
        User u = new User();
        u.setName(request.getParameter("login"));
        u.setAdmin(false);
        u.setPassword(request.getParameter("password"));
        u.setLogged(Boolean.parseBoolean(request.getParameter("admin")));
        u.setAddDate(new Date());
        services.addUser(u);
        return jsonaParser.generateOkObject("Witaj nowy użytkowniku",u);
    }

    @Autowired
    private IUserServices services;
    @Autowired
    private IJsonParser jsonaParser;
}
