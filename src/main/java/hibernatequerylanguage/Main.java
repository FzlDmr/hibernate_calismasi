package hibernatequerylanguage;

import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration().
                configure("hibernate.cfg.xml").
                addAnnotatedClass(Employee.class).
                buildSessionFactory();

        Session session = factory.openSession();
        Transaction tx = null;
        try{
            tx=session.beginTransaction();

            List<String> employeess1 = session.createQuery("select e.name from Employee e group by e.name order by e.name").list();

            for (String w : employeess1) {
                System.out.println(w);
            }

            tx.commit();

        }finally {

        }
    }
}
