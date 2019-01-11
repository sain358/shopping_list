package shoppinglist.console.views;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import shoppinglist.console.domains.ShoppingList;
import shoppinglist.console.domains.User;
import shoppinglist.console.services.ShoppingListError;
import shoppinglist.console.services.shoppinglists.get.GetShoppingListRequest;
import shoppinglist.console.services.shoppinglists.get.GetShoppingListResponse;
import shoppinglist.console.services.shoppinglists.get.GetShoppingListService;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@Component
public class EditShoppingListView {

    @Autowired
    private GetShoppingListService getShoppingListService;

    public Optional<ShoppingList> execute(User user) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("-------------------------");
        System.out.println("Type the Shopping list title:");
        String shoppingListTitle = scanner.nextLine();
        System.out.println("-------------------------");

        GetShoppingListRequest request = new GetShoppingListRequest(user, shoppingListTitle);
        GetShoppingListResponse response = getShoppingListService.execute(request);

        List<ShoppingListError> shoppingListErrors = response.getShoppingListErrors();
        if (!shoppingListErrors.isEmpty()) {
            printErrors(shoppingListErrors);
        }

        return Optional.ofNullable(response.getShoppingList());
    }


    public void printErrors(List<ShoppingListError> shoppingListErrors) {
        for (ShoppingListError shoppingListError : shoppingListErrors) {
            System.out.println(shoppingListError.getDescription());
        }
        System.out.println("-------------------------");
    }

}
