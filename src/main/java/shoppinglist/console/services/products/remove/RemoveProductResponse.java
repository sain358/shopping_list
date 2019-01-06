package shoppinglist.console.services.products.remove;

import shoppinglist.console.services.ShoppingListError;

import java.util.List;

public class RemoveProductResponse {

    private List<ShoppingListError> shoppingListErrors;

    public RemoveProductResponse(List<ShoppingListError> shoppingListErrors) {
        this.shoppingListErrors = shoppingListErrors;
    }

    public List<ShoppingListError> getShoppingListErrors() {
        return shoppingListErrors;
    }

}
