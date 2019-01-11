package shoppinglist.console.services.products.remove.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import shoppinglist.console.services.ShoppingListError;
import shoppinglist.console.services.products.remove.RemoveProductRequest;

import java.util.ArrayList;
import java.util.List;

@Component
public class RemoveProductValidator {

    @Autowired
    private NoSuchProductRule noSuchProductRule;

    public List<ShoppingListError> validate(RemoveProductRequest removeProductRequest) {
        List<ShoppingListError> shoppingListErrors = new ArrayList<>();

        noSuchProductRule.execute(removeProductRequest.getShoppingList(), removeProductRequest.getProductTitle()).ifPresent(shoppingListErrors::add);

        return shoppingListErrors;
    }


}
