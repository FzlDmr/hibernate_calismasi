package onetomany_manytoone;

import hibernatequerylanguage.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class RunnerSave {
    public static void main(String[] args) {

        List<Book> bookList = new ArrayList<>();

        Book book1 = new Book();
        book1.setId(1000);
        book1.setName("Sefiller");


        Author author1 = new Author();
        author1.setId(10);
        author1.setName("Victor Hugo");
        author1.setBooks(bookList);


        book1.setAuthor(author1);


        SessionFactory factory = new Configuration().
                configure("hibernate.cfg.xml").
                addAnnotatedClass(Author.class).addAnnotatedClass(Book.class).
                buildSessionFactory();

        Session session = factory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();


            session.save(book1);
            session.save(author1);

            tx.commit();


        }finally {

        }

    }

}
