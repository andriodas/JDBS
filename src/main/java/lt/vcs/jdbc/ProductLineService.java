package lt.vcs.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductLineService {
    Repository repository = new Repository();

    public List<ProductLine> getProductLines(){

        List<ProductLine> productLines = new ArrayList<>();
        try(Connection connection = repository.getConnection()) {

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from productLines");

            while (resultSet.next()) {
                // System.out.println(resultSet.getInt(1) + " | " + resultSet.getString(2));
                ProductLine productLine = new ProductLine(
                        resultSet.getString("productLine"),
                        resultSet.getString("textDescription"),
                        resultSet.getString("htmlDescription"));

                productLines.add(productLine);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productLines;
    }

}
