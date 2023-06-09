package hibernatequerylanguage;


import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Runner {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration().
                configure("hibernate.cfg.xml").
                addAnnotatedClass(Employee.class).
                buildSessionFactory();


        Session session = factory.openSession();
        Transaction tx = null;

        try {

            tx = session.beginTransaction();

            List<Employee> employees = session.createQuery("from Employee e where e.name='Omer'").list();

            for (Employee employee : employees) {
                System.out.println(employee.getName());
            }

            //insert islemi
            Employee employee1 = new Employee();
            employee1.setName("Ahmet");
            employee1.setSalary(5000);
            session.persist(employee1);

            //update islemi
            String hql = "update Employee set name = :newName where salary = :salary";
            Query query = session.createQuery(hql);
            query.setParameter("newName","Hasan");
            query.setParameter("salary",5000);
            int count = query.executeUpdate();
            System.out.println(count);

            //group by
            List<String> employeess = session.createQuery("select e.name from Employee e group by e.name").list();

            for (String w : employeess) {
                System.out.println(w);
            }

            //group by-order by
            List<String> employeess1 = session.createQuery("select e.name from Employee e group by e.name order by e.name").list();

            for (String w : employeess1) {
                System.out.println(w);
            }


            List<Integer> employeesss = session.createQuery("select e.salary from Employee e group by e.salary").list();

            for (Integer w : employeesss) {
                System.out.println(w);
            }

            //aggregate fon.
            Query query1 = session.createQuery("SELECT SUM(salary) FROM Employee");
            Long salary = (Long) query1.getSingleResult();
            System.out.println(salary);

            List<Long> employeeList = session.createQuery("SELECT SUM(salary) FROM Employee").list();
            //Sum veri tabanindan big decimal tipinde deger donduruyor bundan dolayi data type Long aldik


            for (Long employee : employeeList) {
                System.out.println(employee);
            }

            //group by - having
            List<Object[]> employeeList1 = session.createQuery("select e.name,sum(e.salary) from Employee" +
                    " e group by e.name having sum(e.salary)>40000").list();

            for (Object[] employee : employeeList1) {
                String name = (String) employee[0];
                Long totalSalary = (Long) employee[1];
                System.out.println("Name  " + name + "   Salary   " + totalSalary);
            }


            tx.commit();


            //System.out.println(session.createQuery("select name,city from Employeee join Address on employee.id=employee.id").list());


        } finally {
            //session.close();
        }
    }
}
