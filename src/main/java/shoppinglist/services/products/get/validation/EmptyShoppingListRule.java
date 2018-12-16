package shoppinglist.services.products.get.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import shoppinglist.database.ProductRepository;
import shoppinglist.domains.Product;
import shoppinglist.services.ShoppingListError;

import java.util.List;
import java.util.Optional;

@Component
public class EmptyShoppingListRule {

    @Autowired
    private ProductRepository db;

    public Optional<ShoppingListError> execute() {
        List<Product> products = db.getAllProducts();
        if (products.isEmpty()) {
            ShoppingListError shoppingListError = new ShoppingListError("", "Shopping list is empty!");
            return Optional.of(shoppingListError);
        }
        return Optional.empty();
    }


}
