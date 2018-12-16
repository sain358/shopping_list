package shoppinglist.services.products.get.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import shoppinglist.services.ShoppingListError;
import shoppinglist.services.products.get.GetAllProductsRequest;

import java.util.ArrayList;
import java.util.List;

@Component
public class GetAllProductsValidator {

    @Autowired
    private EmptyShoppingListRule emptyShoppingListRule;

    public List<ShoppingListError> validate(GetAllProductsRequest getAllProductsRequest) {
        List<ShoppingListError> shoppingListErrors = new ArrayList<>();

        emptyShoppingListRule.execute().ifPresent(shoppingListErrors::add);

        return shoppingListErrors;
    }

}
