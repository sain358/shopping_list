package shoppinglist.console.views;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import shoppinglist.console.domains.User;
import shoppinglist.console.services.ShoppingListError;
import shoppinglist.console.services.shoppinglists.remove.RemoveShoppingListRequest;
import shoppinglist.console.services.shoppinglists.remove.RemoveShoppingListResponse;
import shoppinglist.console.services.shoppinglists.remove.RemoveShoppingListService;

import java.util.List;
import java.util.Scanner;

@Component
public class RemoveShoppingListView {

    @Autowired
    private RemoveShoppingListService removeShoppingListService;

    public void execute(User user) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("-------------------------");
        System.out.println("Type the Shopping list title:");
        String shoppingListTitle = scanner.nextLine();
        System.out.println("-------------------------");

        RemoveShoppingListRequest removeShoppingListRequest = new RemoveShoppingListRequest(user, shoppingListTitle);
        RemoveShoppingListResponse addShoppingListResponse = removeShoppingListService.execute(removeShoppingListRequest);

        List<ShoppingListError> shoppingListErrors = addShoppingListResponse.getShoppingListErrors();
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
