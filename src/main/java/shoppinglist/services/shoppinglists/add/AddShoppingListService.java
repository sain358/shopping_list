package shoppinglist.services.shoppinglists.add;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import shoppinglist.database.ShoppingListRepository;
import shoppinglist.domains.ShoppingList;
import shoppinglist.services.ShoppingListError;

import java.util.List;

@Component
@Transactional
public class AddShoppingListService {

    @Autowired
    private ShoppingListRepository shoppingListRepository;

    @Autowired
    private AddShoppingListValidator validator;

    public AddShoppingListResponse execute (AddShoppingListRequest request){

        List<ShoppingListError> shoppingListErrors = validator.validate(request);
        if (!shoppingListErrors.isEmpty()) {
            return new AddShoppingListResponse(shoppingListErrors);
        }

        ShoppingList shoppingList = new ShoppingList();
        shoppingList.setUser(request.getUser());
        shoppingList.setTitle(request.getTitle());
        shoppingListRepository.save(shoppingList);

        return new AddShoppingListResponse(shoppingList);
    }
}
