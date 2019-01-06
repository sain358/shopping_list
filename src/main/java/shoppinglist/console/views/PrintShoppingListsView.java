package shoppinglist.console.views;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import shoppinglist.console.domains.ShoppingList;
import shoppinglist.console.domains.User;
import shoppinglist.console.services.ShoppingListError;
import shoppinglist.console.services.shoppinglists.getAll.GetAllShoppingListsRequest;
import shoppinglist.console.services.shoppinglists.getAll.GetAllShoppingListsResponse;
import shoppinglist.console.services.shoppinglists.getAll.GetAllShoppingListsService;

import java.util.List;

@Component
public class PrintShoppingListsView {

    @Autowired
    private GetAllShoppingListsService getAllShoppingListsService;

    public void execute(User user) {
        GetAllShoppingListsRequest request = new GetAllShoppingListsRequest(user);
        GetAllShoppingListsResponse response = getAllShoppingListsService.execute(request);

        List<ShoppingListError> shoppingListErrors = response.getShoppingListErrors();
        if (!shoppingListErrors.isEmpty()) {
            printErrors(shoppingListErrors);
        }

        System.out.println("-------------------------");
        System.out.println("This is Your shopping lists:");
        for (ShoppingList shoppingList : response.getShoppingLists()) {
            System.out.println(
                    "ID: " + shoppingList.getId() +
                            "; Title: " + shoppingList.getTitle()
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
