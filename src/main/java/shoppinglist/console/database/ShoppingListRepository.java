package shoppinglist.console.database;

import shoppinglist.console.domains.ShoppingList;
import shoppinglist.console.domains.User;

import java.util.List;
import java.util.Optional;

public interface ShoppingListRepository {

    void save(ShoppingList shoppingList);

    void remove(ShoppingList shoppingList);

    Optional<ShoppingList> findByUserAndTitle(User user, String title);

    List<ShoppingList> findShoppingLists(User user);

}