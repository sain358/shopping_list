package shoppinglist.console.services.products.add;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import shoppinglist.console.database.ProductRepository;
import shoppinglist.console.domains.Product;
import shoppinglist.console.services.ShoppingListError;
import shoppinglist.console.services.products.add.validation.AddProductValidator;

import java.util.List;

@Component
@Transactional
public class AddProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private AddProductValidator validator;

    public AddProductResponse execute(AddProductRequest request) {
        Product product = new Product();
        List<ShoppingListError> shoppingListErrors = validator.validate(request);
        if (!shoppingListErrors.isEmpty()) {
            return new AddProductResponse(product, shoppingListErrors);
        }
        product.setTitle(request.getProductTitle());
        product.setDescription(request.getProductDescription());
        product.setQuantity(request.getQuantity());
        product.setShoppingList(request.getShoppingList());
        productRepository.addProduct(product);
        return new AddProductResponse(product, shoppingListErrors);
    }

}
