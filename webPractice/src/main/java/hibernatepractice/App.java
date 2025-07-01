package hibernatepractice;

import hibernatepractice.model.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App {
    public static void main(String[] args) {
        Configuration cfg = new Configuration().addAnnotatedClass(Person.class);

        SessionFactory sf = cfg.buildSessionFactory();
        Session session = sf.getCurrentSession();

        try {
            session.beginTransaction();

            Person person1 = new Person("Test1", 30);
            Person person2 = new Person("Test2", 30);
            Person person3 = new Person("Test3", 30);

            session.save(person1);
            session.save(person2);
            session.save(person3);

            session.getTransaction().commit();
        } finally {
            session.close();
        }


    }
}
