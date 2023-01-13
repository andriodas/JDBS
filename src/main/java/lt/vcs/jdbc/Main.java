package lt.vcs.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {

    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/classicmodels", "root", "root");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from customers");

            while (((ResultSet) resultSet).next()) {
                System.out.println(resultSet.getInt(1) + " | " + resultSet.getString(2));
            }

            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
