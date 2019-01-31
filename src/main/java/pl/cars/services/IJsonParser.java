package pl.cars.services;

import pl.cars.model.Users.User;

public interface IJsonParser {
    String generateErrorObject(String error);
    String generateOkObject(String message, User u);
}
