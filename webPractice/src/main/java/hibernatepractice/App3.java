package hibernatepractice;

import hibernatepractice.model.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class App3 {
    public static void main(String[] args) {
        Configuration cfg = new Configuration()
                .addAnnotatedClass(Person.class)
                .addAnnotatedClass(Item.class)
                .addAnnotatedClass(Passport.class);

        SessionFactory sf = cfg.buildSessionFactory();
        Session session = sf.getCurrentSession();

        try {
            session.beginTransaction();

            Person person = session.get(Person.class, 1);
            session.remove(person);


            session.getTransaction().commit();

        } finally {
            session.close();
        }


    }
}
