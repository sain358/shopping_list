package shoppinglist.console.views;

import shoppinglist.console.services.ShoppingListError;

import java.util.List;

public interface View {

    void execute();

    void printErrors(List<ShoppingListError> shoppingListErrors);

}
