package shoppinglist.services.add;

import org.springframework.stereotype.Component;
import shoppinglist.services.Error;

import java.util.List;

public class AddProductResponse {

    private List<Error> errors;

    public AddProductResponse(List<Error> errors) {
        this.errors = errors;
    }

    public List<Error> getErrors() {
        return errors;
    }

}
