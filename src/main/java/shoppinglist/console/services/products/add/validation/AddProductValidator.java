package shoppinglist.console.services.products.add.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import shoppinglist.console.services.products.add.AddProductRequest;
import shoppinglist.console.services.ShoppingListError;

import java.util.ArrayList;
import java.util.List;

@Component
public class AddProductValidator {

    @Autowired
    private EmptyTitleRule emptyTitleRule;

    @Autowired
    private UniqueProductRule uniqueProductRule;

    public List<ShoppingListError> validate(AddProductRequest addProductRequest) {
        List<ShoppingListError> shoppingListErrors = new ArrayList<>();

        emptyTitleRule.execute(addProductRequest.getProductTitle()).ifPresent(shoppingListErrors::add);
        uniqueProductRule.execute(addProductRequest).ifPresent(shoppingListErrors::add);

        return shoppingListErrors;
    }
}
