package shoppinglist.services.remove.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import shoppinglist.services.Error;
import shoppinglist.services.remove.RemoveProductRequest;

import java.util.ArrayList;
import java.util.List;

@Component
public class RemoveProductValidator {

    @Autowired
    private NoSuchProductRule noSuchProductRule;

    public List<Error> validate(RemoveProductRequest removeProductRequest) {
        List<Error> errors = new ArrayList<>();

        noSuchProductRule.execute(removeProductRequest.getProductTitle()).ifPresent(errors::add);

        return errors;
    }


}
