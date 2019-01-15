package shoppinglist.console.services.shoppinglists.remove;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import shoppinglist.console.database.ShoppingListRepository;
import shoppinglist.console.database.UserRepository;
import shoppinglist.console.domains.ShoppingList;
import shoppinglist.console.domains.User;
import shoppinglist.console.services.ShoppingListError;
import shoppinglist.console.services.shoppinglists.get.GetShoppingListRequest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class RemoveShoppingListValidator {

    @Autowired
    private ShoppingListRepository shoppingListRepository;

    @Autowired
    private UserRepository userRepository;

    public List<ShoppingListError> validate(RemoveShoppingListRequest request) {
        List<ShoppingListError> errors = new ArrayList<>();
        validateShoppingListExistence(request.getUser(), request.getTitle()).ifPresent(errors::add);
        validateUser(request.getUser()).ifPresent(errors::add);
        return errors;
    }

    public Optional<ShoppingListError> validateShoppingListExistence(User user, String title) {
        Optional<ShoppingList> shoppingListOptional = shoppingListRepository.findByUserAndTitle(user, title);
        if (!shoppingListOptional.isPresent()) {
            ShoppingListError shoppingListError = new ShoppingListError("title", "No such Shopping List found!");
            return Optional.of(shoppingListError);
        }
        return Optional.empty();

    }

    private Optional<ShoppingListError> validateUser(User user) {
        Optional<User> userOptional = userRepository.findByLoginAndPassword(user.getLogin(), user.getPassword());
        if (userOptional.isPresent() && !user.equals(userOptional.get())) {
            return Optional.of(new ShoppingListError("user", "No such user found!"));
        }
        return Optional.empty();
    }

}
