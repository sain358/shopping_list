package shoppinglist.services.products.remove.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import shoppinglist.database.ProductRepository;
import shoppinglist.domains.Product;
import shoppinglist.services.ShoppingListError;

import java.util.Optional;

@Component
public class NoSuchProductRule {

    @Autowired
    private ProductRepository db;

    public Optional<ShoppingListError> execute(String title) {
        Optional<Product> product = db.findProductByTitle(title);
        if (!product.isPresent()) {
            ShoppingListError shoppingListError = new ShoppingListError("title", "No such product found!");
            return Optional.of(shoppingListError);
        }
        return Optional.empty();

    }


}
