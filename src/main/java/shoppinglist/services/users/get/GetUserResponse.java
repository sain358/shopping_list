package shoppinglist.services.users.get;


import shoppinglist.domains.User;
import shoppinglist.services.ShoppingListError;

import java.util.List;

public class GetUserResponse {

    private User user;
    private List<ShoppingListError> shoppingListErrors;

    public GetUserResponse(User user) {
        this.user = user;
    }

    public GetUserResponse(List<ShoppingListError> shoppingListErrors) {
        this.shoppingListErrors = shoppingListErrors;
    }

    public User getUser() {
        return user;
    }

    public List<ShoppingListError> getShoppingListErrors() {
        return shoppingListErrors;
    }

}
