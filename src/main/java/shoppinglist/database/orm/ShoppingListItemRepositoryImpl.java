package shoppinglist.database.orm;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import shoppinglist.database.ShoppingListItemRepository;
import shoppinglist.domains.ShoppingListItem;

@Component
@Transactional
class ShoppingListItemRepositoryImpl implements ShoppingListItemRepository {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void save(ShoppingListItem shoppingListItem) {
        sessionFactory.getCurrentSession().save(shoppingListItem);
    }

}
