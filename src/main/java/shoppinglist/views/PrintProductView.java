package shoppinglist.views;

import shoppinglist.database.Database;
import shoppinglist.domains.Product;

public class PrintProductView implements View {

    private Database db;

    public PrintProductView(Database db) {
        this.db = db;
    }

    @Override
    public void execute() {
        System.out.println("This is Your shopping list:");
        for (Product product : db.getAllProducts()) {
            System.out.println(
                    "ID: " + product.getId() +
                            "; Title: " + product.getTitle() +
                            "; Description: " + product.getDescription()
            );
        }
        System.out.println();
    }

}
