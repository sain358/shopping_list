package shoppinglist.console.services.shoppinglists.getAll;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import shoppinglist.console.database.ShoppingListRepository;
import shoppinglist.console.domains.Product;
import shoppinglist.console.domains.ShoppingList;
import shoppinglist.console.services.ShoppingListError;
import shoppinglist.console.services.products.getAll.GetAllProductsResponse;
import shoppinglist.console.services.shoppinglists.get.GetShoppingListRequest;
import shoppinglist.console.services.shoppinglists.get.GetShoppingListResponse;
import shoppinglist.console.services.shoppinglists.get.GetShoppingListValidator;

import java.util.List;
import java.util.Optional;

@Component
@Transactional
public class GetAllShoppingListsService {

    @Autowired
    private ShoppingListRepository shoppingListRepository;

    @Autowired
    private GetAllShoppingListsValidator validator;

    public GetAllShoppingListsResponse execute(GetAllShoppingListsRequest request) {

        List<ShoppingList> shoppingLists = shoppingListRepository.findShoppingLists(request.getUser());
        List<ShoppingListError> shoppingListErrors = validator.validate(request);
        if (!shoppingListErrors.isEmpty()) {
            return new GetAllShoppingListsResponse(shoppingLists, shoppingListErrors);
        }
        return new GetAllShoppingListsResponse(shoppingLists, shoppingListErrors);

    }

}
