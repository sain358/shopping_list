package shoppinglist.services.shoppinglists.getAll;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import shoppinglist.database.ShoppingListRepository;
import shoppinglist.domains.Product;
import shoppinglist.domains.ShoppingList;
import shoppinglist.services.ShoppingListError;
import shoppinglist.services.products.getAll.GetAllProductsResponse;
import shoppinglist.services.shoppinglists.get.GetShoppingListRequest;
import shoppinglist.services.shoppinglists.get.GetShoppingListResponse;
import shoppinglist.services.shoppinglists.get.GetShoppingListValidator;

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
