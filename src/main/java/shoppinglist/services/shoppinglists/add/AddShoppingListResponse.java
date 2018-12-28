package shoppinglist.services.shoppinglists.add;

import shoppinglist.domains.ShoppingList;
import shoppinglist.services.ShoppingListError;

import java.util.List;

public class AddShoppingListResponse {

    private ShoppingList shoppingList;
    private List<ShoppingListError> shoppingListErrors;

    public AddShoppingListResponse(ShoppingList shoppingList) {
        this.shoppingList = shoppingList;
    }

    public AddShoppingListResponse(List<ShoppingListError> shoppingListErrors) {
        this.shoppingListErrors = shoppingListErrors;
    }

    public ShoppingList getShoppingList() {
        return shoppingList;
    }

    public List<ShoppingListError> getShoppingListErrors() {
        return shoppingListErrors;
    }
}