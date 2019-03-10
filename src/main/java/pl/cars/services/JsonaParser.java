package pl.cars.services;


import com.google.gson.Gson;
import org.json.JSONObject;
import pl.cars.model.Cars.Cars;
import pl.cars.model.Cars.ObjectCars;
import pl.cars.model.Users.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class JsonaParser implements IJsonParser{

    public JsonaParser(){
        this.jsonString = new JSONObject();
    }
    @Override
    public String generateErrorObjectForUser(String error){
        jsonString = new JSONObject();
        return jsonString.put("error",error).toString();
    }

    @Override
    public String generateOkObjectForUser(String message, User u) {
        jsonString = new JSONObject();
        return jsonString.put("correct",message).put("user",new JSONObject()
                .put("name",u.getName()).put("zalogowany",true)).toString();
    }

    @Override
    public String generateErrorObjectForCar(String error) {
        jsonString = new JSONObject();
        return jsonString.put("error",error).toString();
    }

    @Override
    public String generateOkObjectForCar(String message, ObjectCars c) {
        jsonString = new JSONObject();
        return jsonString.put("correct",message)
                .put("car",
                        new JSONObject()
                                .put("name",c.getName())
                                .put("type",c.getTypeOfCar())
                                .put("price",c.getPrice())).toString();
    }

    @Override
    public String generateCarsList(String message, List<ObjectCars> c) {
        List tmptab =  new ArrayList();
        for (int i = 0; i < c.size(); i++) {
            String date  = Optional.ofNullable(c.get(i).getData().toString()).orElse("false");

            tmptab.add(new JSONObject()
                    .put("name",c.get(i).getName())
                    .put("type",c.get(i).getTypeOfCar())
                    .put("price",c.get(i).getPrice())
                    .put("isRent",date).toString());
        }
        return jsonString.put("correct",message).put("cars",tmptab.toString()).toString();
    }

    @Override
    public String generateTypeOfCar(String message, List<String> c) {
        return jsonString.put("correct",message).put("type",c.toString()).toString();
    }

    @Override
    public User parseUser(String u) {
        Gson g = new Gson();
        User p = g.fromJson(u, User.class);
        return p;
    }

    @Override
    public ObjectCars parseCar(String obj) {
        Gson g = new Gson();
        ObjectCars c = g.fromJson(obj, ObjectCars.class);
        return c;
    }
    private JSONObject jsonString;
}
