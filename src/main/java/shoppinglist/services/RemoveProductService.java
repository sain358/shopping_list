package shoppinglist.services;

import shoppinglist.domains.Product;
import shoppinglist.database.Database;

import java.util.Optional;

public class RemoveProductService {

    private Database db;

    public RemoveProductService(Database db) {
        this.db = db;
    }

    public void execute(Long productID) {
        Optional<Product> foundProduct = db.findProductByID(productID);
        if (foundProduct.isPresent()){
            Product product = foundProduct.get();
            db.removeProduct(product);
        }
    }
}
