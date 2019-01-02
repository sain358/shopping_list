package shoppinglist.services.users.registration;

import shoppinglist.domains.User;
import shoppinglist.services.ShoppingListError;

import java.util.List;

public class UserRegistrationResponse {

    private User user;
    private List<ShoppingListError> shoppingListErrors;


    public User getUser() {
        return user;
    }

    public List<ShoppingListError> getShoppingListErrors() {
        return shoppingListErrors;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setShoppingListErrors(List<ShoppingListError> shoppingListErrors) {
        this.shoppingListErrors = shoppingListErrors;
    }
}
