package shoppinglist.console.services.shoppinglists.add;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import shoppinglist.console.database.ShoppingListRepository;
import shoppinglist.console.database.UserRepository;
import shoppinglist.console.domains.ShoppingList;
import shoppinglist.console.domains.User;
import shoppinglist.console.services.ShoppingListError;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class AddShoppingListValidator {

    @Autowired
    private ShoppingListRepository shoppingListRepository;

    @Autowired
    private UserRepository userRepository;

    public List<ShoppingListError> validate(AddShoppingListRequest request) {
        List<ShoppingListError> errors = new ArrayList<>();
        validateDuplicateTitle(request.getUser(), request.getTitle()).ifPresent(errors::add);
        validateEmptyTitle(request.getTitle()).ifPresent(errors::add);
        validateUser(request.getUser()).ifPresent(errors::add);
        return errors;
    }

    private Optional<ShoppingListError> validateDuplicateTitle (User user, String title){
        Optional<ShoppingList> shoppingListOptional = shoppingListRepository.findByUserAndTitle(user, title);
        if (shoppingListOptional.isPresent()){
            return Optional.of(new ShoppingListError("title", "This Shopping List already exists!"));
        }
        return Optional.empty();
    }

    private Optional<ShoppingListError> validateEmptyTitle(String title) {
        Pattern pattern = Pattern.compile("^\\s*$");
        Matcher matcher = pattern.matcher(title);
        if (matcher.find()) {
            return Optional.of(new ShoppingListError("title", "Empty title not allowed!"));
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
