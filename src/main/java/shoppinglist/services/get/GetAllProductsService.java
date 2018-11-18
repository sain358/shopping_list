package shoppinglist.services.get;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import shoppinglist.database.ProductRepository;
import shoppinglist.domains.Product;

import java.util.List;

@Component
public class GetAllProductsService {

    @Autowired
    private ProductRepository db;

    public List<Product> getAllProducts() {
        return db.getAllProducts();
    }
}
