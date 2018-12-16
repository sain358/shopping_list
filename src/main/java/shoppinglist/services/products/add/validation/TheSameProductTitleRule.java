package shoppinglist.services.products.add.validation;

import org.springframework.stereotype.Component;
import shoppinglist.database.ProductRepository;
import shoppinglist.domains.Product;
import shoppinglist.services.ShoppingListError;

import java.util.Optional;

@Component
public class TheSameProductTitleRule {

    private ProductRepository repository;

    public TheSameProductTitleRule(ProductRepository repository) {
        this.repository = repository;
    }

    public Optional<ShoppingListError> execute(String title) {
        if (title != null) {
            Optional<Product> product = repository.findProductByTitle(title);
            if (product.isPresent()) {
                ShoppingListError shoppingListError = new ShoppingListError("title", "Same title not allowed!");
                return Optional.of(shoppingListError);
            }
        }
        return Optional.empty();
    }

}
