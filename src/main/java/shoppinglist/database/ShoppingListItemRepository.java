package shoppinglist.database;

import shoppinglist.domains.ShoppingListItem;

public interface ShoppingListItemRepository {

    void save(ShoppingListItem shoppingListItem);

}
