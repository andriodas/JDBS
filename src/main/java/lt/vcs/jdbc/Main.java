package lt.vcs.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {

    public static void main(String[] args) {
        try {
            Connection c = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/classicmodels",
                    "root",
                    "root");
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("select * from customers");

            while (((ResultSet) rs).next())
                System.out.println(rs.getInt(1) + " | " + rs.getString(2));
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
