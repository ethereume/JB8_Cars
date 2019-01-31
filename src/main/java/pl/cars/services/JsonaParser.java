package pl.cars.services;

import org.json.JSONObject;
import pl.cars.model.Users.User;

public class JsonaParser implements IJsonParser{

    public JsonaParser(){
        this.jsonString = new JSONObject();
    }
    @Override
    public String generateErrorObject(String error){
        return jsonString.put("error",error).toString();
    }

    @Override
    public String generateOkObject(String message, User u) {
        return jsonString.put("correct",message).put("user",new JSONObject()
                .put("name",u.getName()).put("zalogowany",true)).toString();
    }

    private JSONObject jsonString;
}
