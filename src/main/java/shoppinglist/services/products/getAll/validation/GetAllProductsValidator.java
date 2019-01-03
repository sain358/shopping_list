package shoppinglist.services.products.getAll.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import shoppinglist.services.ShoppingListError;
import shoppinglist.services.products.getAll.GetAllProductsRequest;

import java.util.ArrayList;
import java.util.List;

@Component
public class GetAllProductsValidator {

    @Autowired
    private EmptyShoppingListRule emptyShoppingListRule;

    public List<ShoppingListError> validate(GetAllProductsRequest request) {
        List<ShoppingListError> shoppingListErrors = new ArrayList<>();

        emptyShoppingListRule.execute(request.getShoppingList()).ifPresent(shoppingListErrors::add);

        return shoppingListErrors;
    }

}
