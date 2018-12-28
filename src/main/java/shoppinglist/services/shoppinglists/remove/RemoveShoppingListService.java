package shoppinglist.services.shoppinglists.remove;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import shoppinglist.database.ShoppingListRepository;
import shoppinglist.domains.ShoppingList;
import shoppinglist.services.ShoppingListError;

import java.util.List;

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

        ShoppingList shoppingList = new ShoppingList();
        shoppingList.setUser(request.getUser());
        shoppingList.setTitle(request.getTitle());
        shoppingListRepository.remove(shoppingList);
        return new RemoveShoppingListResponse(shoppingListErrors);

    }

}
