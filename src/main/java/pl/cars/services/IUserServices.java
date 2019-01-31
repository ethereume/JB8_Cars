package pl.cars.services;

import pl.cars.model.Users.User;

public interface IUserServices  {
    User getUser(String name, String password);
    void addUser(String name,String password);
    void login(boolean login);
    void logout(boolean logout);
}
