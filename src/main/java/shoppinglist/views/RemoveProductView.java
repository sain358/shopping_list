package shoppinglist.views;

import org.springframework.stereotype.Component;
import shoppinglist.services.ShoppingListError;
import shoppinglist.services.products.remove.RemoveProductRequest;
import shoppinglist.services.products.remove.RemoveProductResponse;
import shoppinglist.services.products.remove.RemoveProductService;

import java.util.List;
import java.util.Scanner;

@Component
public class RemoveProductView implements View {

    private RemoveProductService removeProductService;

    public RemoveProductView(RemoveProductService removeProductService) {
        this.removeProductService = removeProductService;
    }

    @Override
    public void execute() {
        System.out.println("-------------------------");
        System.out.println("Type the product title:");
        Scanner scanner = new Scanner(System.in);
        String title = scanner.nextLine();
        System.out.println("-------------------------");

        RemoveProductRequest removeProductRequest = new RemoveProductRequest(title);
        RemoveProductResponse removeProductResponse = removeProductService.execute(removeProductRequest);

        List<ShoppingListError> shoppingListErrors = removeProductResponse.getShoppingListErrors();
        if (!shoppingListErrors.isEmpty()) {
            printErrors(shoppingListErrors);
        }
    }

    @Override
    public void printErrors(List<ShoppingListError> shoppingListErrors) {
        for (ShoppingListError shoppingListError : shoppingListErrors) {
            System.out.println(shoppingListError.getDescription());
        }
        System.out.println("-------------------------");
    }

}

