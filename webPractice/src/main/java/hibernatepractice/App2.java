package hibernatepractice;

import hibernatepractice.model.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class App2 {
    public static void main(String[] args) {
        Configuration cfg = new Configuration()
                .addAnnotatedClass(Person.class)
                .addAnnotatedClass(Item.class);

        SessionFactory sf = cfg.buildSessionFactory();
        Session session = sf.getCurrentSession();

        try {
            session.beginTransaction();

            Person person = new Person("Test cascading", 30);
            person.addItem(new Item("Test item one"));
            person.addItem(new Item("Test item two"));
            person.addItem(new Item("Test item three"));
            session.persist(person);


            session.getTransaction().commit();

        } finally {
            session.close();
        }


    }
}
