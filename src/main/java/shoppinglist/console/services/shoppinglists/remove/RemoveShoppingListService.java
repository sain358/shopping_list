package shoppinglist.console.services.shoppinglists.remove;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import shoppinglist.console.database.ShoppingListRepository;
import shoppinglist.console.domains.ShoppingList;
import shoppinglist.console.services.ShoppingListError;

import java.util.List;
import java.util.Optional;

@Component
@Transactional
public class RemoveShoppingListService {

    @Autowired
    private ShoppingListRepository shoppingListRepository;

    @Autowired
    private RemoveShoppingListValidator validator;

    public RemoveShoppingListResponse execute(RemoveShoppingListRequest request) {

        List<ShoppingListError> shoppingListErrors = validator.validate(request);
        if (!shoppingListErrors.isEmpty()) {
            return new RemoveShoppingListResponse(shoppingListErrors);
        }

        Optional<ShoppingList> shoppingListOptional =
                shoppingListRepository.findByUserAndTitle(request.getUser(), request.getTitle());
        shoppingListRepository.remove(shoppingListOptional.get());
        return new RemoveShoppingListResponse(shoppingListErrors);

    }

}
