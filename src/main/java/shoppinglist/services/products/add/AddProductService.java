package shoppinglist.services.products.add;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import shoppinglist.database.ProductRepository;
import shoppinglist.domains.Product;
import shoppinglist.services.ShoppingListError;
import shoppinglist.services.products.add.validation.AddProductValidator;

import java.util.List;

@Component
@Transactional
public class AddProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private AddProductValidator validator;

    public AddProductResponse execute(AddProductRequest request) {
        List<ShoppingListError> shoppingListErrors = validator.validate(request);
        if (!shoppingListErrors.isEmpty()) {
            return new AddProductResponse(shoppingListErrors);
        }
        Product product = new Product();
        product.setTitle(request.getProductTitle());
        product.setDescription(request.getProductDescription());
        product.setQuantity(request.getQuantity());
        product.setShoppingList(request.getShoppingList());
        productRepository.addProduct(product);
        return new AddProductResponse(shoppingListErrors);
    }

}
