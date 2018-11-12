package shoppinglist.services;

import org.springframework.stereotype.Component;
import shoppinglist.database.ProductRepository;
import shoppinglist.domains.Product;

@Component
public class AddProductService {

    private ProductRepository db;

    public AddProductService(ProductRepository db) {
        this.db = db;
    }

    public boolean execute(String productTitle, String productDescription) {
        boolean isNotCorrectData = false;
        if (productTitle.equals("") || productDescription.equals("")) {
            isNotCorrectData = true;
        } else {
            Product product = new Product();
            product.setTitle(productTitle);
            product.setDescription(productDescription);
            db.addProduct(product);
        }
        return isNotCorrectData;
    }

}
