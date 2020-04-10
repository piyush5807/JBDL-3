package com.example.jdbcdemoex.demoexampledbc;

import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
public class MyController {

    @RequestMapping(value = "/insertTable", method = RequestMethod.POST)
    public void getPerson(@RequestParam("table") String table) throws SQLException {

        DBOperations.getConnection();
        DBOperations.createTable(table);

    }

    @RequestMapping(value = "/insertPerson", method = RequestMethod.POST)
    public void insertPerson(@RequestBody CreateRequest request) throws SQLException {
        DBOperations.getConnection();
        DBOperations.insertPerson(request);
    }

    @GetMapping(value = "/getPersons")
    public List<Person> getPersons() throws SQLException {
        DBOperations.getConnection();


        return DBOperations.getPersons();
    }
}