package shoppinglist.services.remove.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import shoppinglist.database.ProductRepository;
import shoppinglist.domains.Product;
import shoppinglist.services.Error;

import java.util.Optional;

@Component
public class NoSuchProductRule {

    @Autowired
    private ProductRepository db;

    public Optional<Error> execute(String title) {
        Optional<Product> product= db.findProductByTitle(title);
        if (!product.isPresent()) {
            Error error = new Error("title", "No such product found!");
            return Optional.of(error);
        } else {
            return Optional.empty();
        }
    }


}
