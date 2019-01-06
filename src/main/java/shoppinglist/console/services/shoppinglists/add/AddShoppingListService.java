package shoppinglist.console.services.shoppinglists.add;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import shoppinglist.console.database.ShoppingListRepository;
import shoppinglist.console.domains.ShoppingList;
import shoppinglist.console.services.ShoppingListError;

import java.util.List;

@Component
@Transactional
public class AddShoppingListService {

    @Autowired
    private ShoppingListRepository shoppingListRepository;

    @Autowired
    private AddShoppingListValidator validator;

    public AddShoppingListResponse execute (AddShoppingListRequest request){

        AddShoppingListResponse response = new AddShoppingListResponse();

        List<ShoppingListError> shoppingListErrors = validator.validate(request);
        response.setShoppingListErrors(shoppingListErrors);
        if (!shoppingListErrors.isEmpty()) {
            return response;
        }

        ShoppingList shoppingList = new ShoppingList();
        shoppingList.setUser(request.getUser());
        shoppingList.setTitle(request.getTitle());
        shoppingListRepository.save(shoppingList);

        response.setShoppingList(shoppingList);
        return response;
    }
}
