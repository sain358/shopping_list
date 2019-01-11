package shoppinglist.console.services.products.add;

import shoppinglist.console.domains.Product;
import shoppinglist.console.services.ShoppingListError;

import java.util.List;

public class AddProductResponse {

    private Product product;
    private List<ShoppingListError> shoppingListErrors;

    public AddProductResponse(Product product, List<ShoppingListError> shoppingListErrors) {
        this.product = product;
        this.shoppingListErrors = shoppingListErrors;
    }

    public Product getProduct() {
        return product;
    }

    public List<ShoppingListError> getShoppingListErrors() {
        return shoppingListErrors;
    }

}
