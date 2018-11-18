package shoppinglist.services.get.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import shoppinglist.database.ProductRepository;
import shoppinglist.domains.Product;
import shoppinglist.services.Error;

import java.util.List;
import java.util.Optional;

@Component
public class EmptyShoppingListRule {

    @Autowired
    private ProductRepository db;

    public Optional<Error> execute() {
        List<Product> products = db.getAllProducts();
        if (products.isEmpty()) {
            Error error = new Error("", "Shopping list is empty!");
            return Optional.of(error);
        }
        return Optional.empty();
    }


}
