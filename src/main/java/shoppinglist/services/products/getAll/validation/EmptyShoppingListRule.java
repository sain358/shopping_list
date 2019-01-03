package shoppinglist.services.products.getAll.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import shoppinglist.database.ProductRepository;
import shoppinglist.domains.Product;
import shoppinglist.domains.ShoppingList;
import shoppinglist.services.ShoppingListError;

import java.util.List;
import java.util.Optional;

@Component
public class EmptyShoppingListRule {

    @Autowired
    private ProductRepository db;

    public Optional<ShoppingListError> execute(ShoppingList shoppingList) {
        List<Product> products = db.getAllProducts(shoppingList);
        if (products.isEmpty()) {
            ShoppingListError shoppingListError = new ShoppingListError("", "Shopping list is empty!");
            return Optional.of(shoppingListError);
        }
        return Optional.empty();
    }


}
