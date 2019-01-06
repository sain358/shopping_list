package shoppinglist.console.views;

import org.springframework.stereotype.Component;
import shoppinglist.console.domains.Product;
import shoppinglist.console.domains.ShoppingList;
import shoppinglist.console.services.ShoppingListError;
import shoppinglist.console.services.products.getAll.GetAllProductsRequest;
import shoppinglist.console.services.products.getAll.GetAllProductsResponse;
import shoppinglist.console.services.products.getAll.GetAllProductsService;

import java.util.List;

@Component
public class PrintProductView {

    private GetAllProductsService getAllProductsService;

    public PrintProductView(GetAllProductsService getAllProductsService) {
        this.getAllProductsService = getAllProductsService;
    }

    public void execute(ShoppingList shoppingList) {
        GetAllProductsRequest getAllProductsRequest = new GetAllProductsRequest(shoppingList);
        GetAllProductsResponse getAllProductsResponse = getAllProductsService.execute(getAllProductsRequest);

        List<ShoppingListError> shoppingListErrors = getAllProductsResponse.getShoppingListErrors();
        if (!shoppingListErrors.isEmpty()) {
            printErrors(shoppingListErrors);
        }

        System.out.println("-------------------------");
        System.out.println("This is Your shopping list:");
        for (Product product : getAllProductsResponse.getProducts()) {
            System.out.println(
                    "ID: " + product.getId() +
                            "; Title: " + product.getTitle() +
                            "; Description: " + product.getDescription() +
                            "; Quantity: " + product.getQuantity()
            );
        }
        System.out.println("-------------------------");
    }


    public void printErrors(List<ShoppingListError> shoppingListErrors) {
        for (ShoppingListError shoppingListError : shoppingListErrors) {
            System.out.println(shoppingListError.getDescription());
        }
        System.out.println("-------------------------");
    }



}
