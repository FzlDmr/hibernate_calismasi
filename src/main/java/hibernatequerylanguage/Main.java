package hibernatequerylanguage;

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

            Employee employee1 = new Employee();
            employee1.setName("Ahmet");
            employee1.setSalary(5000);
            session.persist(employee1);
            tx.commit();

        }finally {

        }
    }
}
