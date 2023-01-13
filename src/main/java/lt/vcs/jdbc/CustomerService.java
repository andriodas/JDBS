package lt.vcs.jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerService {
    Repository repository = new Repository();

    public List<Customer> getAllCustomers() {
        List<Customer> customers = new ArrayList<>();
        try {
            Statement statement = repository.getConnection().createStatement();
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

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customers;

    }

    public void createCustomer(Customer customer) {
        String sql = "INSERT INTO customers (" +
                "customerNumber, customerName, contactLastName, contactFirstName, " +
                "phone, addressLine1, city, country)VALUES(?,?,?,?,?,?,?,?)";

        try {
            PreparedStatement preparedStatement = repository.getConnection().prepareStatement(sql);
            preparedStatement.setInt(1, customer.getCustomerNumber());
            preparedStatement.setString(2, customer.getCustomerName());
            preparedStatement.setString(3, customer.getContactLastName());
            preparedStatement.setString(4, customer.getContactFirstName());
            preparedStatement.setString(5, customer.getPhone());
            preparedStatement.setString(6, customer.getAddressLine1());
            preparedStatement.setString(7, customer.getCity());
            preparedStatement.setString(8, customer.getCountry());

            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
