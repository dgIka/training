package hibernatepractice;

import hibernatepractice.model.Actor;
import hibernatepractice.model.Movie;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class App5 {
    public static void main(String[] args) {
        Configuration cfg = new Configuration()
                .addAnnotatedClass(Movie.class)
                .addAnnotatedClass(Actor.class);
        SessionFactory sf = cfg.buildSessionFactory();


        try (sf) {
            Session session = sf.getCurrentSession();
            session.beginTransaction();


            Actor actor = session.get(Actor.class, 2);
            System.out.println(actor.getMovies());

            session.getTransaction().commit();
        }
    }
}
