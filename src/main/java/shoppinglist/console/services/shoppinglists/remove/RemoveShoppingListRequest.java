package shoppinglist.console.services.shoppinglists.remove;

import shoppinglist.console.domains.User;

public class RemoveShoppingListRequest {

    private User user;
    private String title;

    public RemoveShoppingListRequest(User user, String title) {
        this.user = user;
        this.title = title;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}

