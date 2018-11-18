package shoppinglist.views;

import org.springframework.stereotype.Component;
import shoppinglist.domains.Product;
import shoppinglist.services.get.GetAllProductsService;

@Component
public class PrintProductView implements View {

    private GetAllProductsService getAllProductsService;

    public PrintProductView(GetAllProductsService getShoppingListService) {
        this.getAllProductsService = getShoppingListService;
    }

    @Override
    public void execute() {
        System.out.println("-------------------------");
        System.out.println("This is Your shopping list:");
        for (Product product : getAllProductsService.getAllProducts()) {
            System.out.println(
                    "ID: " + product.getId() +
                            "; Title: " + product.getTitle() +
                            "; Description: " + product.getDescription()
            );
        }
        System.out.println("-------------------------");
    }

}
