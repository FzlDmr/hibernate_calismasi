package hibernatequerylanguage;
import jakarta.persistence.*;
@Entity
public class Book {
    @Id
    private Integer id;
    private String name;
    @ManyToOne
    @JoinColumn(name="AUTHOR_ID")
    private Author author;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return
                " id= " + id +
                " name= " + name +
                " author= " + author;
    }
}
