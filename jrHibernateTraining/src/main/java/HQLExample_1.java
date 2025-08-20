import entity.Person;
import org.hibernate.ScrollableResults;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class HQLExample_1 {
    private final SessionFactory sessionFactory;

    public HQLExample_1(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void getAllUsers() {
        try(Session session = sessionFactory.openSession()) {
            session.beginTransaction();

            Query<Person> query = session.createQuery("from Person", Person.class);
            query.setFirstResult(2); //аналог offset
            query.setMaxResults(10); //аналог limit
            List<Person> resultList = query.getResultList();
            resultList.forEach(System.out::println);

            session.getTransaction().commit();
        }
    }

    public void getPersonById(int id) {
        try(Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Query<Person> query = session.createQuery("from Person p where p.id = :id", Person.class);
            query.setParameter("id", id);
            List<Person> resultList = query.getResultList();
            if (resultList.size() > 0) {
                resultList.forEach(System.out::println);
            } else {
                System.out.println("No person found with id " + id);
            }
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

    public void processPersonsAsStream() {
        try(Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Query<Person> query = session.createQuery("from Person", Person.class);
            query.stream().map(Person::getFirst_name).forEach(System.out::println);
            session.getTransaction().commit();
        }
    }

    public void scrollFirstThreePersons() {
        try(Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Query<Person> query = session.createQuery("from Person", Person.class);
            ScrollableResults<Person> results = query.scroll();
            results.first();
            for (int i = 0; i < 3 && results.next(); i++) {
                Person person = results.get();
                System.out.println(person.getFirst_name() + " " + person.getSecond_name());
            }
            session.getTransaction().commit();
        }
    }

    public void findPersonByUsernameList(List<String> names) {
        try(Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Query<Person> query = session.createQuery("from Person p where p.first_name IN (:name)", Person.class);
            query.setParameterList("name", names);
            List<Person> resultList = query.getResultList();
            resultList.forEach(System.out::println);
            session.getTransaction().commit();
        }
    }
    public void getAllUsersWithSorting() {


        try(Session session = sessionFactory.openSession()) {
            session.beginTransaction();

            Query<Person> query = session.createQuery("from Person p ORDER BY p.first_name", Person.class);
            List<Person> resultList = query.getResultList();
            resultList.forEach(a -> System.out.println(a.getFirst_name()));

            session.getTransaction().commit();
        }
    }

    public void getPersonWithPassport() {
        try(Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Query<Object[]> query = session.createQuery("select p, p.passport.number from Person p where p.passport is not null", Object[].class);
            List<Object[]> resultList = query.getResultList();
            resultList.stream()
                    .map(row -> Arrays.stream(row)
                            .map(Object::toString)
                            .collect(Collectors.joining(", ")))
                    .forEach(System.out::println);
            session.getTransaction().commit();


        }
    }
}
