package com.example.jdbcdemoex.demoexampledbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBOperations {

    private static volatile Connection connection;

    public static Connection getConnection() throws SQLException {

        if(connection == null){
            synchronized (DBOperations.class){

                if(connection == null){
                    connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/persons", "", "");
                }
            }
        }

        return connection;

    }

    public static void closeConnection() throws SQLException {

        if(connection != null){
            synchronized (DBOperations.class){

                if(connection != null){
                    connection.close();
                }
            }
        }

    }


    public static void createTable(String tableName) throws SQLException {

        try {
            Statement statement = connection.createStatement();
            statement.execute("CREATE TABLE " + tableName + " ( id INT PRIMARY KEY AUTO_INCREMENT, name VARCHAR(30), last_name VARCHAR(30), age INT )");
            System.out.println("Table " + tableName + " is created successfully");
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    public static void insertPerson(CreateRequest request) throws SQLException {

        PreparedStatement statement = connection.prepareStatement("INSERT INTO persons VALUES(null, ?, ?, ?)");
        statement.setString(1, request.getName());
        statement.setString(2, request.getSurname());
        statement.setInt(3, request.getAge());

        int rows_affected = statement.executeUpdate();

        if(rows_affected > 0 ){
            System.out.println("Person " + request + " has been successfully inserted");
        }else{
            System.out.println("Person " + request + " cannot be successfully inserted");
        }

    }


    public static List<Person> getPersons() throws SQLException {
        List<Person> result = new ArrayList<>();
        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM persons");

        while(rs.next()){

            result.add(new Person(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4)));

        }

        return result;
    }

}
