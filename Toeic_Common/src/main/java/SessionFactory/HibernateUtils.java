package SessionFactory;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class HibernateUtils {
    private static SessionFactory buildSessionFactory(){
        try {
            return  new Configuration().configure().buildSessionFactory();
        }catch (Exception e){
            throw new ExceptionInInitializerError();
        }
    }
    public static SessionFactory getSessionFactory(){
return buildSessionFactory();
    }
}
