package hibernatepractice;

import hibernatepractice.model.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) {
        Configuration cfg = new Configuration().addAnnotatedClass(Person.class).addAnnotatedClass(Item.class);

        SessionFactory sf = cfg.buildSessionFactory();
        Session session = sf.getCurrentSession();

        try {
            session.beginTransaction();

//            Item item = session.get(Item.class, 5);
//            System.out.println(item);
//
//            Person person = item.getOwner();
//            System.out.println(person);

//            Person person = session.get(Person.class, 2);
//            Item item = new Item("MacBook PRO", person);
//            session.save(item);

//            Person person = new Person("Very new person", 30);
//            Item newItem = new Item("Item for very new person", person);
//            person.setItems(List.of(newItem));
//            session.save(person);
//            session.save(newItem);

//            Person person = session.get(Person.class, 3);
//            List<Item> items = person.getItems();
//            items.stream().forEach(a -> session.remove(a));
//            person.getItems().clear();



            session.getTransaction().commit();

        } finally {
            session.close();
        }


    }
}
