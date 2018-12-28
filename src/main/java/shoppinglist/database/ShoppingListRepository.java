package shoppinglist.database;

import shoppinglist.domains.ShoppingList;
import shoppinglist.domains.User;

import java.util.List;
import java.util.Optional;

public interface ShoppingListRepository {

    void save(ShoppingList shoppingList);

    void remove(ShoppingList shoppingList);

    Optional<ShoppingList> findByUserAndTitle(User user, String title);


}