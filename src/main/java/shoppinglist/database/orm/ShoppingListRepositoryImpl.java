package shoppinglist.database.orm;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import shoppinglist.database.ShoppingListRepository;
import shoppinglist.domains.ShoppingList;
import shoppinglist.domains.User;

import java.util.Optional;

@Component
@Transactional
class ShoppingListRepositoryImpl implements ShoppingListRepository {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void save(ShoppingList shoppingList) {
        sessionFactory.getCurrentSession().save(shoppingList);
    }

    @Override
    public Optional<ShoppingList> findByUserAndTitle(User user, String title) {
        String query = "from ShoppingList sl where sl.title = :title and sl.user = :user";
        ShoppingList shoppingList = (ShoppingList) sessionFactory.getCurrentSession().createQuery(query)
                .setParameter("title", title)
                .setParameter("user", user)
                .uniqueResult();
        return Optional.ofNullable(shoppingList);
    }

}
