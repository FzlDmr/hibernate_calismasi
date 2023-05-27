package hibernateonetoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateEntryDemo {

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

            // Get object with id = 1
            int id = 1;
            Student student
                    = session.get(Student.class, id);
            StudentGfgDetail studentGfgDetail
                    = student.getStudentGfgDetail();

            // modify the student and its details
            student.setEmail("vyom@geeksforgeeks.com");
            studentGfgDetail.setNoOfProblemsSolved(40);

            // Update the student object.
            // This will also update the StudentGfgDetail
            // object as we have used CascadeType.ALL
            session.persist(student);

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