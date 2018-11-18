package shoppinglist.services.get;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import shoppinglist.database.ProductRepository;
import shoppinglist.domains.Product;
import shoppinglist.services.Error;
import shoppinglist.services.add.AddProductResponse;
import shoppinglist.services.get.validation.GetAllProductsValidator;

import java.util.List;

@Component
public class GetAllProductsService {

    @Autowired
    private ProductRepository db;

    @Autowired
    private GetAllProductsValidator validator;


    public GetAllProductsResponse execute(GetAllProductsRequest getAllProductsRequest) {
        List<Product> products = db.getAllProducts();
        List<Error> errors = validator.validate(getAllProductsRequest);
        if (!errors.isEmpty()) {
            return new GetAllProductsResponse(products, errors);
        }
        return new GetAllProductsResponse(products, errors);

    }
}
