package shoppinglist.services.products.remove.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import shoppinglist.services.ShoppingListError;
import shoppinglist.services.products.remove.RemoveProductRequest;

import java.util.ArrayList;
import java.util.List;

@Component
public class RemoveProductValidator {

    @Autowired
    private NoSuchProductRule noSuchProductRule;

    public List<ShoppingListError> validate(RemoveProductRequest removeProductRequest) {
        List<ShoppingListError> shoppingListErrors = new ArrayList<>();

        noSuchProductRule.execute(removeProductRequest.getProductTitle()).ifPresent(shoppingListErrors::add);

        return shoppingListErrors;
    }


}
