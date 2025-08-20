import entity.Passport;
import entity.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

public class HIbernateApp {
    public static void main(String[] args) {
        Configuration cfg = new Configuration().addAnnotatedClass(Person.class).addAnnotatedClass(Passport.class);

        SessionFactory sf = cfg.buildSessionFactory();
        Session session = sf.getCurrentSession();

//        try { //добавление новой записи
//            session.beginTransaction();
//            Person person = new Person();
//            person.setBirth_date(LocalDate.now());
//            person.setFirst_name("Hibernate2");
//            person.setSecond_name("Test2");
//
//            Passport passport = new Passport();
//            passport.setNumber(99999999);
//
//            person.setPassport(passport);
//
//            session.persist(person);
//            session.getTransaction().commit();
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            session.getTransaction().rollback();
//        } finally {
//            session.close();
//        }

//        try {  //удаление
//            session.beginTransaction();
//            Person person = session.get(Person.class, 103);
//            Person person1 = session.get(Person.class, 104);
//
//            session.delete(person);
//            session.delete(person1);
//            session.getTransaction().commit();
//            System.out.println("Объекты удалены --------------------------------");
//        } catch (Exception e) {
//            System.out.println("Объекты не удалены --------------------------------");
//            session.getTransaction().rollback();
//        } finally {
//            session.close();
//        }

        try {
            HQLExample_1 hqlExample1 = new HQLExample_1(sf);
            hqlExample1.getAllUsers();
            hqlExample1.getAllUsersWithSorting();
            hqlExample1.getPersonWithPassport();
        } catch (Exception e) {
            e.printStackTrace();
        }

//        try {
//            HQLExample_1 hqlExample1 = new HQLExample_1(sf);
//            hqlExample1.getPersonsName();/
//            hqlExample1.scrollFirstThreePersons();
//            hqlExample1.getPersonById(15);
//            ArrayList<String> names = new ArrayList<>();
//            names.add("Todd");
//            names.add("Dennis");
//            names.add("Sara");
//            hqlExample1.findPersonByUsernameList(names);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }
}
