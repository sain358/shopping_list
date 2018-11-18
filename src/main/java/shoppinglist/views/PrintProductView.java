package shoppinglist.views;

import org.springframework.stereotype.Component;
import shoppinglist.domains.Product;
import shoppinglist.services.Error;
import shoppinglist.services.get.GetAllProductsRequest;
import shoppinglist.services.get.GetAllProductsResponse;
import shoppinglist.services.get.GetAllProductsService;

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

        List<Error> errors = getAllProductsResponse.getErrors();
        if (!errors.isEmpty()) {
            printErrors(errors);
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



    private void printErrors(List<Error> errors) {
        for (Error error : errors) {
            System.out.println(error.getDescription());
        }
        System.out.println("-------------------------");
    }



}
