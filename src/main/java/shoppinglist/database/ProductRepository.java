package shoppinglist.database;

import shoppinglist.domains.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {

    void addProduct(Product product);

    void removeProduct(Product product);

    Optional<Product> findProductByID(Long id);

    List<Product> getAllProducts();
}
