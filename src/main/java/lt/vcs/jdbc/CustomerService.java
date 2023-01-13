package lt.vcs.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CustomerService {
    Repository repository = new Repository();



    public List<Customer> getAllCustomers() {
        List<Customer> customers = new ArrayList<>();
        try(Connection connection = repository.getConnection()) {

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from customers");

            while (resultSet.next()) {
                // System.out.println(resultSet.getInt(1) + " | " + resultSet.getString(2));
                Customer customer = new Customer(
                        resultSet.getInt("customerNumber"),
                        resultSet.getString("customerName"),
                        resultSet.getString("phone"),
                        resultSet.getString("city"));

                customers.add(customer);
            }
            customers.forEach(System.out::println);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customers;

    }
}
