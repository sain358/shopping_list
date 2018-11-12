package shoppinglist.views;

import org.springframework.stereotype.Component;
import shoppinglist.database.ProductRepository;
import shoppinglist.domains.Product;

@Component
public class PrintProductView implements View {

    private ProductRepository db;

    public PrintProductView(ProductRepository db) {
        this.db = db;
    }

    @Override
    public void execute() {
        System.out.println("-------------------------");
        System.out.println("This is Your shopping list:");
        for (Product product : db.getAllProducts()) {
            System.out.println(
                    "ID: " + product.getId() +
                            "; Title: " + product.getTitle() +
                            "; Description: " + product.getDescription()
            );
        }
        System.out.println("-------------------------");
    }

}
