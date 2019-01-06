package shoppinglist.console.database;

import shoppinglist.console.domains.ShoppingList;
import shoppinglist.console.domains.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {

    void save(User user);

    Optional<User> findByLoginAndPassword(String login, String password);

    Optional<User> findByLogin(String login);

    Optional<User> findById(Long userId);

}
