package hibernatepractice;

import hibernatepractice.model.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) {
        Configuration cfg = new Configuration().addAnnotatedClass(Person.class).addAnnotatedClass(Item.class)
                .addAnnotatedClass(Director.class)
                .addAnnotatedClass(Movie.class);

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
//            Director director = session.get(Director.class, 1);
//            System.out.println(director.getName());
//            director.getMovies().forEach(System.out::println);
//            System.out.println("------------------------");
//            Movie movie = session.get(Movie.class, 8);
//            System.out.println(movie.getName());
//            System.out.println(movie.getDirector().getName());

//            Director director1 = session.get(Director.class, 3);
//            Movie movie1 = new Movie("Master", director1, 2025);
//            director1.getMovies().add(movie1);
//            session.save(movie1);
//            Director director2 = session.get(Director.class, 8);
//            Movie movie2 = new Movie("Lord of the rings", director2, 2002);
//            session.update(director2);
//            session.save(movie2);

            Movie movie = session.get(Movie.class, 14);
            Director director = movie.getDirector();
            director.setMovies(Collections.singletonList(null));
            movie.setDirector(session.get(Director.class, 4));

            session.update(movie);

            session.getTransaction().commit();

        } finally {
            session.close();
        }


    }
}
