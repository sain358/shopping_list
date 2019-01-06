package shoppinglist.console.services.shoppinglists.getAll;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import shoppinglist.console.database.ShoppingListRepository;
import shoppinglist.console.domains.ShoppingList;
import shoppinglist.console.domains.User;
import shoppinglist.console.services.ShoppingListError;
import shoppinglist.console.services.shoppinglists.get.GetShoppingListRequest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class GetAllShoppingListsValidator {

    @Autowired
    private ShoppingListRepository shoppingListRepository;

    public List<ShoppingListError> validate(GetAllShoppingListsRequest request) {
        List<ShoppingListError> errors = new ArrayList<>();
        validateEmptyShoppingList(request.getUser()).ifPresent(errors::add);
        return errors;
    }

    public Optional<ShoppingListError> validateEmptyShoppingList(User user) {
        List<ShoppingList> shoppingLists = shoppingListRepository.findShoppingLists(user);
        if (shoppingLists.isEmpty()) {
            ShoppingListError shoppingListError = new ShoppingListError("", "There are no Shopping Lists!");
            return Optional.of(shoppingListError);
        }
        return Optional.empty();
    }

}
