package shoppinglist.services.shoppinglists.get;

import shoppinglist.domains.ShoppingList;
import shoppinglist.services.ShoppingListError;

import java.util.List;

public class GetShoppingListResponse {

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
