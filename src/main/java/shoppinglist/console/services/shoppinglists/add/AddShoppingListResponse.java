package shoppinglist.console.services.shoppinglists.add;

import shoppinglist.console.domains.ShoppingList;
import shoppinglist.console.services.ShoppingListError;

import java.util.List;

public class AddShoppingListResponse {

    private ShoppingList shoppingList;
    private List<ShoppingListError> shoppingListErrors;


    public ShoppingList getShoppingList() {
        return shoppingList;
    }

    public List<ShoppingListError> getShoppingListErrors() {
        return shoppingListErrors;
    }

    public void setShoppingList(ShoppingList shoppingList) {
        this.shoppingList = shoppingList;
    }

    public void setShoppingListErrors(List<ShoppingListError> shoppingListErrors) {
        this.shoppingListErrors = shoppingListErrors;
    }
}
