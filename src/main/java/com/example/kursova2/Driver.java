package com.example.kursova2;

import java.sql.*;

public class Driver {
    String dbHost = "localhost";
    String dbPort = "3306";
    String dbUser = "root";
    String dbPass = "12345";
    String dbName = "kursova";

    public void addSweet(Sweets sweet){
        String insert = "INSERT INTO infogift " +
                " (idSweets, NameSweets, Weight, sugarcontent)"
                + " VALUES ('" + sweet.getIdSweets() + "', '" + sweet.getNameSweets() + "', '" + sweet.getWeight() + "', " +
                sweet.getSugarcontent() + ")";

        Connection myCon = null;
        try {
            myCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/kursova", "root", "12345");

            Statement myStmt = myCon.createStatement();

            myStmt.executeUpdate(insert);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet viewSweet() {
        ResultSet resSet = null;

        String select = "SELECT * FROM infogift";
        try {
            Connection myCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/kursova", "root", "12345");


            PreparedStatement prSt = myCon.prepareStatement(select);

            resSet = prSt.executeQuery();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return resSet;

    }

    public void delSweet(int id){
        String delete = "DELETE FROM infogift WHERE idSweets = " + id;


        Connection myCon = null;
        try {
            myCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/kursova", "root", "12345");

            Statement myStmt = myCon.createStatement();

            myStmt.executeUpdate(delete);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet searchSugarSweet(int x1, int x2) {
        ResultSet resSet = null;

        String select = "SELECT * FROM infogift WHERE sugarcontent >=? AND sugarcontent <=?";
        try {
            Connection myCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/kursova", "root", "12345");


            PreparedStatement prSt = myCon.prepareStatement(select);
            prSt.setInt(1,x1);
            prSt.setInt(2,x2);
            resSet = prSt.executeQuery();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return resSet;
    }

    public void truncatetable(){
        String truncate = "DELETE FROM infogift";

        try {
            Connection myCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/kursova", "root", "12345");

            Statement myStmt = myCon.createStatement();

            myStmt.executeUpdate(truncate);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}