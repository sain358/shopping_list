package shoppinglist.database.orm;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import shoppinglist.database.ProductRepository;
import shoppinglist.domains.Product;

import java.util.List;
import java.util.Optional;

@Component
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
    public List<Product> getAllProducts() {
        List<Product> products = sessionFactory.getCurrentSession().
                createCriteria(Product.class).
                list();
        return products;
    }
}
