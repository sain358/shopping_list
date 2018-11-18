package shoppinglist.services.add.validation;

import org.springframework.stereotype.Component;
import shoppinglist.database.ProductRepository;
import shoppinglist.domains.Product;
import shoppinglist.services.Error;

import java.util.Optional;

@Component
public class DuplicateProductTitleRule {

    private ProductRepository repository;

    public DuplicateProductTitleRule(ProductRepository repository) {
        this.repository = repository;
    }

    public Optional<Error> execute(String title) {
        if (title != null) {
            Optional<Product> product = repository.findProductByTitle(title);
            if (product.isPresent()) {
                Error error = new Error("title", "Same title not allowed!");
                return Optional.of(error);
            }
        }
        return Optional.empty();
    }

}
