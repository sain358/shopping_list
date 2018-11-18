package shoppinglist.services.remove;

import shoppinglist.services.Error;

import java.util.List;

public class RemoveProductResponse {

    private List<Error> errors;

    public RemoveProductResponse(List<Error> errors) {
        this.errors = errors;
    }

    public List<Error> getErrors() {
        return errors;
    }

}
