package shoppinglist.console.database;

import shoppinglist.console.domains.Product;
import shoppinglist.console.domains.ShoppingList;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class InMemoryProductRepository implements ProductRepository {

    private List<Product> products = new ArrayList<>();

    @Override
    public void addProduct(Product product) {
        products.add(product);
    }

    @Override
    public void removeProduct(Product product) {
        products.remove(product);
    }

    @Override
    public Optional<Product> findByShoppingListAndTitle(ShoppingList shoppingList, String title) {
        for (Product product : products) {
            if (product.getTitle().equals(title)){
                return Optional.of(product);
            }
        }
        return Optional.empty();
    }

    @Override
    public List<Product> getAllProducts(ShoppingList shoppingList) {
        return new ArrayList<>(products);
    }
}
