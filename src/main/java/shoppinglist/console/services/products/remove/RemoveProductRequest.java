package shoppinglist.console.services.products.remove;

import shoppinglist.console.domains.ShoppingList;

public class RemoveProductRequest {
    private ShoppingList shoppingList;
    private String productTitle;

    public RemoveProductRequest(ShoppingList shoppingList, String productTitle) {
        this.shoppingList = shoppingList;
        this.productTitle = productTitle;
    }

    public ShoppingList getShoppingList() {
        return shoppingList;
    }

    public String getProductTitle() {
        return productTitle;
    }
}
