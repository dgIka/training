import entity.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class HQLExample_1 {
    private final SessionFactory sessionFactory;

    public HQLExample_1(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void getAllUsers() {


        try(Session session = sessionFactory.openSession()) {
            session.beginTransaction();

            Query<Person> query = session.createQuery("from Person", Person.class);
            List<Person> resultList = query.getResultList();
            resultList.forEach(System.out::println);

            session.getTransaction().commit();
        }
    }

    public void getPersonById() {
        try(Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Query<Person> query = session.createQuery("from Person", Person.class);
        }
    }

    public void getPersonsName() {
        try(Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Query<String> query = session.createQuery("SELECT CONCAT(p.first_name, ' ', p.second_name) FROM Person p", String.class);
            List<String> resultList = query.getResultList();
            resultList.forEach(System.out::println);
        }
    }
}
