package shoppinglist.console.services.shoppinglists.getAll;

import shoppinglist.console.domains.User;

public class GetAllShoppingListsRequest {

    private User user;

    public GetAllShoppingListsRequest(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
