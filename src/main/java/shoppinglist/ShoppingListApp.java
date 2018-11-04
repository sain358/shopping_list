package shoppinglist;

import shoppinglist.database.Database;
import shoppinglist.database.InMemoryDatabase;
import shoppinglist.services.AddProductService;
import shoppinglist.services.PrintProductService;
import shoppinglist.services.RemoveProductService;
import shoppinglist.views.AddProductView;
import shoppinglist.views.PrintProductView;
import shoppinglist.views.RemoveProductView;
import shoppinglist.views.MenuView;

public class ShoppingListApp {

    private static Database db = new InMemoryDatabase();

    private static PrintProductService printProductService = new PrintProductService(db);
    private static AddProductService addProductService = new AddProductService(db);
    private static RemoveProductService removeProductService = new RemoveProductService(db);

    private static MenuView menuView = new MenuView();
    private static PrintProductView printProductView = new PrintProductView(printProductService);
    private static AddProductView addProductView = new AddProductView(addProductService);
    private static RemoveProductView removeProductView = new RemoveProductView(removeProductService);

    public static void main(String[] args) {
        while (true) {
            String menuNumber = menuView.execute();
            if (menuNumber.equals("1")) {
                printProductView.execute();
            } else if (menuNumber.equals("2")) {
                addProductView.execute();
            } else if (menuNumber.equals("3")) {
                removeProductView.execute();
            } else if (menuNumber.equals("4")) {
                break;
            }
        }
    }
}

