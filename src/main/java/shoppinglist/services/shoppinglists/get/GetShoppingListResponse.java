package shoppinglist.services.shoppinglists.get;

import shoppinglist.domains.ShoppingList;
import shoppinglist.services.ShoppingListError;

import java.util.List;

public class GetShoppingListResponse {

    private ShoppingList shoppingList;
    private List<ShoppingListError> shoppingListErrors;

    public GetShoppingListResponse(ShoppingList shoppingList) {
        this.shoppingList = shoppingList;
    }

    public GetShoppingListResponse(List<ShoppingListError> shoppingListErrors) {
        this.shoppingListErrors = shoppingListErrors;
    }

    public ShoppingList getShoppingList() {
        return shoppingList;
    }

    public List<ShoppingListError> getShoppingListErrors() {
        return shoppingListErrors;
    }
}
