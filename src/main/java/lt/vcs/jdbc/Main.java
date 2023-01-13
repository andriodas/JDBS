package lt.vcs.jdbc;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        CustomerService customerService = new CustomerService();
        ProductLineService productLineService = new ProductLineService();


        List<Customer> customers = customerService.getAllCustomers();
        List<ProductLine> productLines = productLineService.getProductLines();

        customers.forEach(System.out::println);
        productLines.forEach(System.out::println);

        Customer customer01 = new Customer(
                504,
                "customerName_03",
                "lastName_03",
                "firstName_03",
                "just-phone",
                "address_03",
                "Vilnius",
                "Lithuania"
        );
        customerService.createCustomer(customer01);

        customers = customerService.getAllCustomers();
        customers.forEach(System.out::println);
        try {
            Repository.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

