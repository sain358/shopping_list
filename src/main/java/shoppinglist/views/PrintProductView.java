package shoppinglist.views;

import org.springframework.stereotype.Component;
import shoppinglist.domains.Product;
import shoppinglist.services.ShoppingListError;
import shoppinglist.services.products.getAll.GetAllProductsRequest;
import shoppinglist.services.products.getAll.GetAllProductsResponse;
import shoppinglist.services.products.getAll.GetAllProductsService;

import java.util.List;

@Component
public class PrintProductView implements View {

    private GetAllProductsService getAllProductsService;

    public PrintProductView(GetAllProductsService getShoppingListService) {
        this.getAllProductsService = getShoppingListService;
    }

    @Override
    public void execute() {
        GetAllProductsRequest getAllProductsRequest = new GetAllProductsRequest();
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
                            "; Description: " + product.getDescription()
            );
        }
        System.out.println("-------------------------");
    }


    @Override
    public void printErrors(List<ShoppingListError> shoppingListErrors) {
        for (ShoppingListError shoppingListError : shoppingListErrors) {
            System.out.println(shoppingListError.getDescription());
        }
        System.out.println("-------------------------");
    }



}
