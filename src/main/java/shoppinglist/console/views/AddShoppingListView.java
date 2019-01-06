package shoppinglist.console.views;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import shoppinglist.console.domains.User;
import shoppinglist.console.services.ShoppingListError;
import shoppinglist.console.services.shoppinglists.add.AddShoppingListRequest;
import shoppinglist.console.services.shoppinglists.add.AddShoppingListResponse;
import shoppinglist.console.services.shoppinglists.add.AddShoppingListService;

import java.util.List;
import java.util.Scanner;

@Component
public class AddShoppingListView {

    @Autowired
    private AddShoppingListService addShoppingListService;

    public void execute(User user) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("-------------------------");
        System.out.println("Type the Shopping list title:");
        String shoppingListTitle = scanner.nextLine();
        System.out.println("-------------------------");

        AddShoppingListRequest addShoppingListRequest = new AddShoppingListRequest(user, shoppingListTitle);
        AddShoppingListResponse addShoppingListResponse = addShoppingListService.execute(addShoppingListRequest);

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
