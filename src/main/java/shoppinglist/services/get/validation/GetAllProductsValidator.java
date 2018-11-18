package shoppinglist.services.get.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import shoppinglist.services.Error;
import shoppinglist.services.add.AddProductRequest;
import shoppinglist.services.get.GetAllProductsRequest;

import java.util.ArrayList;
import java.util.List;

@Component
public class GetAllProductsValidator {

    @Autowired
    private EmptyShoppingListRule emptyShoppingListRule;

    public List<Error> validate(GetAllProductsRequest getAllProductsRequest) {
        List<Error> errors = new ArrayList<>();

        emptyShoppingListRule.execute().ifPresent(errors::add);

        return errors;
    }

}
