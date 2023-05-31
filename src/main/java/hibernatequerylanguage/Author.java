package hibernatequerylanguage;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Author {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    @OneToMany(mappedBy = "author")
    private List<Book> books = new ArrayList<>();

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

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return
                " id = " + id +
                " name = " + name +
                " books = " + books;
    }
}
