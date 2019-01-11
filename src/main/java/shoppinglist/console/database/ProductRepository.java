package shoppinglist.console.database;

import shoppinglist.console.domains.Product;
import shoppinglist.console.domains.ShoppingList;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {

    void addProduct(Product product);

    void removeProduct(Product product);

    Optional<Product> findByShoppingListAndTitle(ShoppingList shoppingList, String title);

    List<Product> getAllProducts(ShoppingList shoppingList);
}
