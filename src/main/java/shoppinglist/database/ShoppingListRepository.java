package shoppinglist.database;

import shoppinglist.domains.ShoppingList;
import shoppinglist.domains.User;

import java.util.Optional;

public interface ShoppingListRepository {

    void save(ShoppingList shoppingList);

    Optional<ShoppingList> findByUserAndTitle(User user, String title);

}