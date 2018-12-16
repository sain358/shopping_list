package shoppinglist.services.products.get;

import shoppinglist.domains.Product;
import shoppinglist.services.ShoppingListError;

import java.util.List;

public class GetAllProductsResponse {

    private List<Product> products;
    private List<ShoppingListError> shoppingListErrors;

    public GetAllProductsResponse(List<Product> products, List<ShoppingListError> shoppingListErrors) {
        this.products = products;
        this.shoppingListErrors = shoppingListErrors;
    }

    public List<Product> getProducts() {
        return products;
    }

    public List<ShoppingListError> getShoppingListErrors() {
        return shoppingListErrors;
    }
}
