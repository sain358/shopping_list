package shoppinglist.console.services.products.getAll;

import shoppinglist.console.domains.ShoppingList;

public class GetAllProductsRequest {

    private ShoppingList shoppingList;

    public GetAllProductsRequest(ShoppingList shoppingList) {
        this.shoppingList = shoppingList;
    }

    public ShoppingList getShoppingList() {
        return shoppingList;
    }
}
