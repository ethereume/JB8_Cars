package pl.cars.services;


import com.google.gson.Gson;
import jdk.nashorn.internal.parser.JSONParser;
import org.json.JSONObject;
import pl.cars.model.Users.User;

public class JsonaParser implements IJsonParser{

    public JsonaParser(){
        this.jsonString = new JSONObject();
    }
    @Override
    public String generateErrorObject(String error){
        jsonString = new JSONObject();
        return jsonString.put("error",error).toString();
    }

    @Override
    public String generateOkObject(String message, User u) {
        jsonString = new JSONObject();
        return jsonString.put("correct",message).put("user",new JSONObject()
                .put("name",u.getName()).put("zalogowany",true)).toString();
    }

    @Override
    public User parseUser(String u) {
        Gson g = new Gson();
        User p = g.fromJson(u, User.class);
        return p;
    }

    private JSONObject jsonString;
}
