package shoppinglist.services.products.add.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import shoppinglist.services.products.add.AddProductRequest;
import shoppinglist.services.ShoppingListError;

import java.util.ArrayList;
import java.util.List;

@Component
public class AddProductValidator {

    @Autowired
    private EmptyTitleRule emptyTitleRule;

    @Autowired
    private TheSameProductTitleRule theSameProductTitleRule;

    public List<ShoppingListError> validate(AddProductRequest addProductRequest) {
        List<ShoppingListError> shoppingListErrors = new ArrayList<>();

        emptyTitleRule.execute(addProductRequest.getProductTitle()).ifPresent(shoppingListErrors::add);

        theSameProductTitleRule.execute(addProductRequest.getProductTitle()).ifPresent(shoppingListErrors::add);

        return shoppingListErrors;
    }
}
