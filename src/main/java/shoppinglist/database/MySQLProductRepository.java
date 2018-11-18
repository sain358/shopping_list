package shoppinglist.database;

import org.springframework.stereotype.Component;
import shoppinglist.domains.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class MySQLProductRepository extends JDBCConnection implements ProductRepository {

    @Override
    public void addProduct(Product product) {
        Connection connection = getConnection();
        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("insert into products(id, title, description) values(default, ?, ?)");
            preparedStatement.setString(1, product.getTitle());
            preparedStatement.setString(2, product.getDescription());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection(connection);
        }
    }

    @Override
    public void removeProduct(Product product) {
        Connection connection = getConnection();
        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("delete from products where id = ?");
            preparedStatement.setLong(1, product.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection(connection);
        }
    }

    @Override
    public Optional<Product> findProductByTitle(String title) {
        Connection connection = getConnection();
        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("select * from products where title = ?");
            preparedStatement.setString(1, title);
            ResultSet resultSet = preparedStatement.executeQuery();
            Product product = null;
            if (resultSet.next()) {
                product = new Product();
                product.setId(resultSet.getLong("id"));
                product.setTitle(resultSet.getString("title"));
                product.setDescription(resultSet.getString("description"));
            }
            return Optional.ofNullable(product);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection(connection);
        }
        return Optional.empty();
    }

    @Override
    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        Connection connection = getConnection();
        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("select * from products");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Product product = new Product();
                product.setId(resultSet.getLong("id"));
                product.setTitle(resultSet.getString("title"));
                product.setDescription(resultSet.getString("description"));
                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection(connection);
        }
        return products;
    }
}
