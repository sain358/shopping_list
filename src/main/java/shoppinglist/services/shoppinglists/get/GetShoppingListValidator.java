package shoppinglist.services.shoppinglists.get;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import shoppinglist.database.ShoppingListRepository;
import shoppinglist.domains.ShoppingList;
import shoppinglist.domains.User;
import shoppinglist.services.ShoppingListError;
import shoppinglist.services.shoppinglists.add.AddShoppingListRequest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class GetShoppingListValidator {

    @Autowired
    private ShoppingListRepository shoppingListRepository;

    public List<ShoppingListError> validate(GetShoppingListRequest request) {
        List<ShoppingListError> errors = new ArrayList<>();
        validateShoppingListExistence(request.getUser(), request.getTitle()).ifPresent(errors::add);
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

}
