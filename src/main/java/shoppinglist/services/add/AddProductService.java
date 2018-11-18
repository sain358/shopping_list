package shoppinglist.services.add;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import shoppinglist.database.ProductRepository;
import shoppinglist.domains.Product;
import shoppinglist.services.Error;
import shoppinglist.services.add.validation.AddProductValidator;

import java.util.List;

@Component
public class AddProductService {

    @Autowired
    private ProductRepository db;

    @Autowired
    private AddProductValidator validator;

    public AddProductResponse execute(AddProductRequest addProductRequest) {
        List<Error> errors = validator.validate(addProductRequest);
        if (!errors.isEmpty()) {
            return new AddProductResponse(errors);
        }
        Product product = new Product();
        product.setTitle(addProductRequest.getProductTitle());
        product.setDescription(addProductRequest.getProductDescription());
        db.addProduct(product);
        return new AddProductResponse(errors);
    }

}
