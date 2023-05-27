package hibernateonetoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class AddEntryBidirectionalDemo {

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

            // Create relevant object.
            Student student = new Student("JJ", "Olatunji",
                    "jj@gmail.com");

            StudentGfgDetail studentGfgDetail
                    = new StudentGfgDetail("GFG College", 0);

            student.setStudentGfgDetail(studentGfgDetail);
            studentGfgDetail.setStudent(student);

            // Begin the transaction
            session.beginTransaction();

            // Save the studentGfgDetail object.
            // This will also save the student object as we
            // have used CascadeType.ALL
            session.persist(studentGfgDetail);

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