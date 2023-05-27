package hibernatequerylanguage;

import jakarta.persistence.*;

@Entity
@Table(name = "EMPLOYEE")
public class Employee {

    @Id
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "salary")
    private int salary;

   // @OneToOne(mappedBy = "employee")
   // private Address address;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

   // public Address getAddress() {
   //     return address;
   // }

  // public void setAddress(Address address) {
  //     this.address = address;
  // }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}