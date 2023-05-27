package hibernateonetoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ReadEntryBidirectionalDemo {

    public static void main(String[] args)
    {

        // Create session factory
        SessionFactory factory
                = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .addAnnotatedClass(StudentGfgDetail.class)
                .buildSessionFactory();

        // Create session
        try (factory; Session session
                = factory.getCurrentSession()) {
            // Begin the transaction
            session.beginTransaction();

            int theId = 1;
            StudentGfgDetail studentGfgDetail = session.get(
                    StudentGfgDetail.class, theId);

            System.out.println(
                    studentGfgDetail.getStudent());
            System.out.println(studentGfgDetail);

            // Commit the transaction
            session.getTransaction().commit();

            System.out.println(
                    "Transaction Successfully Completed!");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}