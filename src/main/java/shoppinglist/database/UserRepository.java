package shoppinglist.database;

import shoppinglist.domains.ShoppingList;
import shoppinglist.domains.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {

    void save(User user);

    Optional<User> findByLoginAndPassword(String login, String password);

    Optional<User> findByLogin(String login);

    Optional<User> findById(Long userId);

}
