package shoppinglist.services.get;

import shoppinglist.domains.Product;
import shoppinglist.services.Error;

import java.util.List;

public class GetAllProductsResponse {

    private List<Product> products;
    private List<Error> errors;

    public GetAllProductsResponse(List<Product> products, List<Error> errors) {
        this.products = products;
        this.errors = errors;
    }

    public List<Product> getProducts() {
        return products;
    }

    public List<Error> getErrors() {
        return errors;
    }
}
