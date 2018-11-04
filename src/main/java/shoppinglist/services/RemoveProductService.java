package shoppinglist.services;

import shoppinglist.domains.Product;
import shoppinglist.database.Database;

import java.util.Optional;

public class RemoveProductService {

    private Database db;

    public RemoveProductService(Database db) {
        this.db = db;
    }

    public void execute(String productTitle) {
        Optional<Product> foundProduct = db.findProductByTitle(productTitle);
        if (foundProduct.isPresent()){
            Product product = foundProduct.get();
            db.removeProduct(product);
        }
    }
}
