package pl.cars.services;

import pl.cars.model.Users.User;

public interface IUserServices  {
    User getUser(String name, String password);
    void addUser(User u);
    void loginAndLogOut(User u,boolean login);
    User getSingleUser(int id);
}
