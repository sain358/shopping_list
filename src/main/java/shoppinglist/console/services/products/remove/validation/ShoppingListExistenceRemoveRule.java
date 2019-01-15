package shoppinglist.console.services.products.remove.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import shoppinglist.console.database.ShoppingListRepository;
import shoppinglist.console.domains.ShoppingList;
import shoppinglist.console.services.ShoppingListError;
import shoppinglist.console.services.products.add.AddProductRequest;
import shoppinglist.console.services.products.remove.RemoveProductRequest;

import java.util.Optional;

@Component
public class ShoppingListExistenceRemoveRule {

    @Autowired
    private ShoppingListRepository shoppingListRepository;

    public Optional<ShoppingListError> execute(RemoveProductRequest request) {
        Optional<ShoppingList> shoppingListOptional =
                shoppingListRepository.findByUserAndTitle(
                        request.getShoppingList().getUser(),
                        request.getShoppingList().getTitle());
        if (shoppingListOptional.isPresent() && !request.getShoppingList().equals(shoppingListOptional.get())) {
            ShoppingListError shoppingListError = new ShoppingListError("shopping list", "No such shopping list found!");
            return Optional.of(shoppingListError);
        }
        return Optional.empty();
    }

}
