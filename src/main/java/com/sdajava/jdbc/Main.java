package com.sdajava.jdbc;

import java.sql.*;

public class Main {

    public static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    public static final String DB_URL
        = "jdbc:mysql://localhost/ksiegarnia?useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

    public static final String USER = "root";
    public static final String PASSWORD = "";

    public static void main(String[] args) {
	// write your code here

        Connection connection = null;
        Statement statement = null;

        try{
            Class.forName(JDBC_DRIVER);

            System.out.println("Lacze z baza danych...");

            connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);

            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from books");

            while (resultSet.next()){
                System.out.println(resultSet.getString("title"));
            }

            resultSet.close();
            statement.close();
            connection.close();

        }catch (SQLException ex){
            ex.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }



    }
}
