package shoppinglist.console.services.products.getAll;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import shoppinglist.console.database.ProductRepository;
import shoppinglist.console.domains.Product;
import shoppinglist.console.services.ShoppingListError;
import shoppinglist.console.services.products.getAll.validation.GetAllProductsValidator;

import java.util.List;

@Component
@Transactional
public class GetAllProductsService {

    @Autowired
    private ProductRepository db;

    @Autowired
    private GetAllProductsValidator validator;


    public GetAllProductsResponse execute(GetAllProductsRequest request) {
        List<Product> products = db.getAllProducts(request.getShoppingList());
        List<ShoppingListError> shoppingListErrors = validator.validate(request);
        if (!shoppingListErrors.isEmpty()) {
            return new GetAllProductsResponse(products, shoppingListErrors);
        }
        return new GetAllProductsResponse(products, shoppingListErrors);

    }
}
