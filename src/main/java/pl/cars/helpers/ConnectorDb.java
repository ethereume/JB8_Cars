package pl.cars.helpers;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ConnectorDb {
    private ConnectorDb(){}
    public static SessionFactory getConnection(){
        if(DB != null) {
            return DB;
        } else  {
            try{
                DB = new Configuration().configure().buildSessionFactory();
                System.out.println("Connection do database set !!");
            }catch (Exception e) {
                System.out.println("Connected cannot by set !!");
                DB = null;
            }
        }
        return DB;
    }

    private static SessionFactory DB;
}
