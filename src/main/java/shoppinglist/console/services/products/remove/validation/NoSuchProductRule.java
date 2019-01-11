package shoppinglist.console.services.products.remove.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import shoppinglist.console.database.ProductRepository;
import shoppinglist.console.domains.Product;
import shoppinglist.console.domains.ShoppingList;
import shoppinglist.console.services.ShoppingListError;

import java.util.Optional;

@Component
public class NoSuchProductRule {

    @Autowired
    private ProductRepository db;

    public Optional<ShoppingListError> execute(ShoppingList shoppingList, String title) {
        Optional<Product> product = db.findByShoppingListAndTitle(shoppingList, title);
        if (!product.isPresent()) {
            ShoppingListError shoppingListError = new ShoppingListError("title", "No such product found!");
            return Optional.of(shoppingListError);
        }
        return Optional.empty();

    }


}
