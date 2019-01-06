package shoppinglist.console.services.products.add;

import shoppinglist.console.services.ShoppingListError;

import java.util.List;

public class AddProductResponse {

    private List<ShoppingListError> shoppingListErrors;

    public AddProductResponse(List<ShoppingListError> shoppingListErrors) {
        this.shoppingListErrors = shoppingListErrors;
    }

    public List<ShoppingListError> getShoppingListErrors() {
        return shoppingListErrors;
    }

}
