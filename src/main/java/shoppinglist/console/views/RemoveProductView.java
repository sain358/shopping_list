package shoppinglist.console.views;

import org.springframework.stereotype.Component;
import shoppinglist.console.domains.ShoppingList;
import shoppinglist.console.services.ShoppingListError;
import shoppinglist.console.services.products.remove.RemoveProductRequest;
import shoppinglist.console.services.products.remove.RemoveProductResponse;
import shoppinglist.console.services.products.remove.RemoveProductService;

import java.util.List;
import java.util.Scanner;

@Component
public class RemoveProductView{

    private RemoveProductService removeProductService;

    public RemoveProductView(RemoveProductService removeProductService) {
        this.removeProductService = removeProductService;
    }

    public void execute(ShoppingList shoppingList) {
        System.out.println("-------------------------");
        System.out.println("Type the product title:");
        Scanner scanner = new Scanner(System.in);
        String title = scanner.nextLine();
        System.out.println("-------------------------");

        RemoveProductRequest removeProductRequest = new RemoveProductRequest(shoppingList, title);
        RemoveProductResponse removeProductResponse = removeProductService.execute(removeProductRequest);

        List<ShoppingListError> shoppingListErrors = removeProductResponse.getShoppingListErrors();
        if (!shoppingListErrors.isEmpty()) {
            printErrors(shoppingListErrors);
        }
    }

    public void printErrors(List<ShoppingListError> shoppingListErrors) {
        for (ShoppingListError shoppingListError : shoppingListErrors) {
            System.out.println(shoppingListError.getDescription());
        }
        System.out.println("-------------------------");
    }

}

