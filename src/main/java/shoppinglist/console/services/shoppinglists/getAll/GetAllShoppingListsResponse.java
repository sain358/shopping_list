package shoppinglist.console.services.shoppinglists.getAll;

import shoppinglist.console.domains.ShoppingList;
import shoppinglist.console.services.ShoppingListError;

import java.util.List;

public class GetAllShoppingListsResponse {

    private List<ShoppingList> shoppingLists;
    private List<ShoppingListError> shoppingListErrors;

    public GetAllShoppingListsResponse(List<ShoppingList> shoppingLists, List<ShoppingListError> shoppingListErrors) {
        this.shoppingLists = shoppingLists;
        this.shoppingListErrors = shoppingListErrors;
    }

    public List<ShoppingList> getShoppingLists() {
        return shoppingLists;
    }

    public List<ShoppingListError> getShoppingListErrors() {
        return shoppingListErrors;
    }
}
