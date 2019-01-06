package shoppinglist.console.database.orm;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import shoppinglist.console.database.ProductRepository;
import shoppinglist.console.domains.Product;
import shoppinglist.console.domains.ShoppingList;

import java.util.List;
import java.util.Optional;

@Component
@Transactional
public class ProductRepositoryImpl implements ProductRepository {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addProduct(Product product) {
        sessionFactory.getCurrentSession().
                save(product);
    }

    @Override
    public void removeProduct(Product product) {
        sessionFactory.getCurrentSession().
                delete(product);
    }

    @Override
    public Optional<Product> findProductByTitle(String title) {
        Product product = (Product) sessionFactory.getCurrentSession().
                createCriteria(Product.class).
                add(Restrictions.eq("title", title)).
                uniqueResult();
        return Optional.ofNullable(product);
    }

    @Override
    public List<Product> getAllProducts(ShoppingList shoppingList) {
        List<Product> products = sessionFactory.getCurrentSession().
                createCriteria(Product.class).
                add(Restrictions.eq("shoppingList", shoppingList)).
                list();
        return products;
    }
}
