package com.example.jpademo3.demojpa3;

import org.hibernate.annotations.GeneratorType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;

import javax.persistence.*;

@Entity
public class Book {

    @Autowired
    BookCategory book_Category;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @Column(name = "price")
    private int cost;

    @ManyToOne
    @JoinColumn
    private BookCategory bookCategory;

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

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public Book(String name, int cost) {
        this.name = name;
        this.cost = cost;
    }

    public Book(String name, int cost, int bookCategoryId){
        this.name = name;
        this.cost = cost;
        this.bookCategory.setId(bookCategoryId);
    }

    public BookCategory getBookCategory() {
        return bookCategory;
    }

    public void setBookCategory(BookCategory bookCategory) {
        this.bookCategory = bookCategory;
    }

    public Book(){

    }

    public String toString(){
        return "name = " + this.name + ", cost = " + this.cost;
    }
}
