package shoppinglist.services.remove;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import shoppinglist.domains.Product;
import shoppinglist.database.ProductRepository;
import shoppinglist.services.Error;
import shoppinglist.services.remove.validation.RemoveProductValidator;

import java.util.List;
import java.util.Optional;

@Component
public class RemoveProductService {

    @Autowired
    private ProductRepository db;

    @Autowired
    private RemoveProductValidator validator;

    public RemoveProductResponse execute(RemoveProductRequest removeProductRequest) {
        List<Error> errors = validator.validate(removeProductRequest);

        if (!errors.isEmpty()) {
            return new RemoveProductResponse(errors);
        }
        Optional<Product> foundProduct = db.findProductByTitle(removeProductRequest.getProductTitle());
        db.removeProduct(foundProduct.get());
        return new RemoveProductResponse(errors);
    }
}
