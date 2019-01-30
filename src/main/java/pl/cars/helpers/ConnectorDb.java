package pl.cars.helpers;

import org.hibernate.Session;
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
                return DB;
            }catch (Exception e) {
                DB = null;
            }
        }
        return DB;
    }

    private static SessionFactory DB;
}
