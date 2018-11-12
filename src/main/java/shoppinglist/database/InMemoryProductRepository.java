package shoppinglist.database;

import shoppinglist.domains.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class InMemoryProductRepository implements ProductRepository {

    private List<Product> products = new ArrayList<>();

    @Override
    public void addProduct(Product product) {
        products.add(product);
    }

    @Override
    public void removeProduct(Product product) {
        products.remove(product);
    }

    @Override
    public Optional<Product> findProductByID(Long id) {
        for (Product product : products) {
            if (product.getId().equals(id)){
                return Optional.of(product);
            }
        }
        return Optional.empty();
    }

    @Override
    public List<Product> getAllProducts() {
        return new ArrayList<>(products);
    }
}
