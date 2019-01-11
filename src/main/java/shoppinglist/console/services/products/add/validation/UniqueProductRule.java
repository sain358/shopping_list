package shoppinglist.console.services.products.add.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import shoppinglist.console.database.ProductRepository;
import shoppinglist.console.domains.Product;
import shoppinglist.console.services.ShoppingListError;
import shoppinglist.console.services.products.add.AddProductRequest;

import java.util.Optional;

@Component
public class UniqueProductRule {

    @Autowired
    private ProductRepository productRepository;

    public Optional<ShoppingListError> execute(AddProductRequest request) {

        Optional<Product> productOptional = productRepository.findByShoppingListAndTitle(
                request.getShoppingList(), request.getProductTitle());

        if (productOptional.isPresent()) {
            ShoppingListError shoppingListError = new ShoppingListError("product", "This product already exists!");
            return Optional.of(shoppingListError);
        }
        return Optional.empty();

    }


}
