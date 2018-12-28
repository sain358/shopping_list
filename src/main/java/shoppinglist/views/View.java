package shoppinglist.views;

import shoppinglist.services.ShoppingListError;

import java.util.List;

public interface View {

    void execute();

    void printErrors(List<ShoppingListError> shoppingListErrors);

}
