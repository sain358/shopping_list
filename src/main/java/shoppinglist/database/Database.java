package shoppinglist.database;

import shoppinglist.domains.Product;

import java.util.List;
import java.util.Optional;

public interface Database {

    void addProduct(Product product);

    void removeProduct(Product product);

    Optional<Product> findProductByTitle(String title);

    List<Product> getAllProducts();
}
