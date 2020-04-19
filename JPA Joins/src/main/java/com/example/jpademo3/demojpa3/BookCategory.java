package com.example.jpademo3.demojpa3;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Iterator;
import java.util.Set;

@Entity
public class BookCategory {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;

    private String name;

    private String description;

    @OneToMany(mappedBy = "bookCategory", cascade = CascadeType.ALL)
    private Set<Book> books;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    public BookCategory(String name, String description, Set<Book> books) {
        this.name = name;
        this.description = description;
        this.books = books;
        this.books.forEach(x -> x.setBookCategory(this));

//        Iterator it = books.iterator();
//        while(it.hasNext()){
//            Book book = (Book)it.next();
//            book.setBookCategory(this);
//        }

    }

    public BookCategory(String name, String description){
        this.name = name;
        this.description = description;
    }

    public BookCategory(){

    }

    @Override
    public String toString() {
        return "id = " + this.getId() + ", name = " + this.getName() + ", description = " + this.getDescription() + ", books = " + this.getBooks();
    }
}
