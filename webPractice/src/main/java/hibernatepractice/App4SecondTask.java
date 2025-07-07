package hibernatepractice;

import hibernatepractice.model.SDirector;
import hibernatepractice.model.School;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App4SecondTask {
    public static void main(String[] args) {
        Configuration configuration = new Configuration()
                .addAnnotatedClass(SDirector.class)
                .addAnnotatedClass(School.class);

        SessionFactory factory = configuration.buildSessionFactory();
        Session session = factory.getCurrentSession();

        try{
            session.beginTransaction();


            SDirector sDirector = session.get(SDirector.class, 2);
            School school = session.get(School.class, 4);
            school.setDirector(sDirector);


            session.getTransaction().commit();
        } finally {
            session.close();
        }
    }
}
