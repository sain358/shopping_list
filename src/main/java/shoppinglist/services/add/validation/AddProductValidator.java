package shoppinglist.services.add.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import shoppinglist.services.add.AddProductRequest;
import shoppinglist.services.add.validation.DuplicateProductTitleRule;
import shoppinglist.services.add.validation.EmptyTitleRule;
import shoppinglist.services.Error;

import java.util.ArrayList;
import java.util.List;

@Component
public class AddProductValidator {

    @Autowired
    private EmptyTitleRule emptyTitleRule;

    @Autowired
    private DuplicateProductTitleRule duplicateProductTitleRule;

    public List<Error> validate(AddProductRequest addProductRequest) {
        List<Error> errors = new ArrayList<>();

        emptyTitleRule.execute(addProductRequest.getProductTitle()).ifPresent(errors::add);

        duplicateProductTitleRule.execute(addProductRequest.getProductTitle()).ifPresent(errors::add);

        return errors;
    }
}
