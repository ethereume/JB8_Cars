package pl.cars.model.Users;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tUser")
public class User {


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getAddDate() {
        return addDate;
    }

    public void setAddDate(Date addDate) {
        this.addDate = addDate;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public boolean isLogged() {
        return logged;
    }

    public int getId() {
        return id;
    }

    public void setLogged(boolean logged) {
        this.logged = logged;
    }

    @Override
    public String toString() {
        return "{" +
                "name:'" + name + '\'' +
                ", password:'" + password + '\'' +
                ", addDate:" + addDate +
                ", isAdmin:" + isAdmin +
                '}';
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @Column(name = "NAME")
    private String name;
    @Column(name = "PASSWORD")
    private String password;
    @Column(name = "DATE_ADD")
    private Date addDate;
    @Column(name = "IS_ADMIN")
    private boolean isAdmin;
    @Column(name = "LOGGED")
    private boolean logged;
}
