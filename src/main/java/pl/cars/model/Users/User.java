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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
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

    public void setLogged(boolean logged) {
        this.logged = logged;
    }

    @Override
    public String toString() {
        return "{" +
                "name:'" + name + '\'' +
                ", surname:'" + surname + '\'' +
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
    @Column(name = "SURNAME")
    private String surname;
    @Column(name = "DATE_ADD")
    private Date addDate;
    @Column(name = "IS_ADMIN")
    private boolean isAdmin;
    @Column(name = "LOGGED")
    private boolean logged;
}
