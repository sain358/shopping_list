package shoppinglist.services;

import shoppinglist.domains.Product;
import shoppinglist.database.Database;

public class PrintProductService {

    private Database db;

    public PrintProductService(Database db) {
        this.db = db;
    }

    public void execute() {
        for (Product product : db.getAllProducts()) {
            System.out.println(product.getTitle() + " " + product.getDescription());
        }
    }

}
