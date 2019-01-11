package shoppinglist.console.services.products.remove;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import shoppinglist.console.domains.Product;
import shoppinglist.console.database.ProductRepository;
import shoppinglist.console.services.ShoppingListError;
import shoppinglist.console.services.products.remove.validation.RemoveProductValidator;

import java.util.List;
import java.util.Optional;

@Component
@Transactional
public class RemoveProductService {

    @Autowired
    private ProductRepository db;

    @Autowired
    private RemoveProductValidator validator;

    public RemoveProductResponse execute(RemoveProductRequest removeProductRequest) {
        List<ShoppingListError> shoppingListErrors = validator.validate(removeProductRequest);

        if (!shoppingListErrors.isEmpty()) {
            return new RemoveProductResponse(shoppingListErrors);
        }
        Optional<Product> foundProduct = db.findByShoppingListAndTitle(
                removeProductRequest.getShoppingList(),removeProductRequest.getProductTitle());
        db.removeProduct(foundProduct.get());
        return new RemoveProductResponse(shoppingListErrors);
    }
}
