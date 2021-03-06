package shoppinglist.console.services.shoppinglists.get;

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
public class GetShoppingListService {

    @Autowired
    private ShoppingListRepository shoppingListRepository;

    @Autowired
    private GetShoppingListValidator validator;

    public GetShoppingListResponse execute (GetShoppingListRequest request){

        GetShoppingListResponse response = new GetShoppingListResponse();

        List<ShoppingListError> shoppingListErrors = validator.validate(request);
        response.setShoppingListErrors(shoppingListErrors);
        if (!shoppingListErrors.isEmpty()) {
            return response;
        }

        Optional<ShoppingList> shoppingListOptional = shoppingListRepository.findByUserAndTitle(request.getUser(), request.getTitle());
        ShoppingList shoppingList = new ShoppingList();
        if (shoppingListOptional.isPresent()) {
            shoppingList = shoppingListOptional.get();
        }

        response.setShoppingList(shoppingList);
        return response;

    }

}
