package shoppinglist.services;

import org.springframework.stereotype.Component;
import shoppinglist.database.Database;
import shoppinglist.domains.Product;

@Component
public class AddProductService {

    private Database db;

    public AddProductService(Database db) {
        this.db = db;
    }

    public void execute(String productTitle, String productDescription) {
        Product product = new Product();
        product.setTitle(productTitle);
        product.setDescription(productDescription);
        db.addProduct(product);
    }

}
