package com.example.jpademo3.demojpa3;

import org.hibernate.annotations.GeneratorType;
import org.springframework.context.annotation.ComponentScan;

import javax.persistence.*;

@Entity
@Table(name = "my_books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "book_name")
    private String name;

    @Column(name = "price")
    private int cost;

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

    public Book(){

    }

    public String toString(){
        return "name = " + this.name + ", cost = " + this.cost;
    }
}
