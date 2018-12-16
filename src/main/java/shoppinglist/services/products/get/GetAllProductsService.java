package shoppinglist.services.products.get;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import shoppinglist.database.ProductRepository;
import shoppinglist.domains.Product;
import shoppinglist.services.ShoppingListError;
import shoppinglist.services.products.get.validation.GetAllProductsValidator;

import java.util.List;

@Component
@Transactional
public class GetAllProductsService {

    @Autowired
    private ProductRepository db;

    @Autowired
    private GetAllProductsValidator validator;


    public GetAllProductsResponse execute(GetAllProductsRequest getAllProductsRequest) {
        List<Product> products = db.getAllProducts();
        List<ShoppingListError> shoppingListErrors = validator.validate(getAllProductsRequest);
        if (!shoppingListErrors.isEmpty()) {
            return new GetAllProductsResponse(products, shoppingListErrors);
        }
        return new GetAllProductsResponse(products, shoppingListErrors);

    }
}
