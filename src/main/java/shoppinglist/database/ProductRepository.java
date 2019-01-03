package shoppinglist.database;

import shoppinglist.domains.Product;
import shoppinglist.domains.ShoppingList;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {

    void addProduct(Product product);

    void removeProduct(Product product);

    Optional<Product> findProductByTitle(String title);

    List<Product> getAllProducts(ShoppingList shoppingList);
}
