package shoppinglist.services;

import org.springframework.stereotype.Component;
import shoppinglist.domains.Product;
import shoppinglist.database.ProductRepository;

import java.util.Optional;

@Component
public class RemoveProductService {

    private ProductRepository db;

    public RemoveProductService(ProductRepository db) {
        this.db = db;
    }

    public boolean execute(Long productID) {
        boolean isNotCorrectData = false;
        Optional<Product> foundProduct = db.findProductByID(productID);
        if (foundProduct.isPresent()) {
            Product product = foundProduct.get();
            db.removeProduct(product);
        } else isNotCorrectData = true;
        return isNotCorrectData;
    }
}
