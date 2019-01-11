package shoppinglist.console;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import shoppinglist.console.config.SpringConfig;
import shoppinglist.console.domains.ShoppingList;
import shoppinglist.console.domains.User;
import shoppinglist.console.views.AddProductView;
import shoppinglist.console.views.PrintProductView;
import shoppinglist.console.views.RemoveProductView;
import shoppinglist.console.menus.ShoppingListMenu;

public class ShoppingListApp {

    public static void main(String[] args) {

        User user = new User();
        user.setLogin("me");
        user.setPassword("123");

        ShoppingList shoppingList = new ShoppingList();
        shoppingList.setTitle("myList");
        shoppingList.setUser(user);
        shoppingList.setId((long) 1001);
        ////////////////////////////////////////////////////////////////////////

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);

        ShoppingListMenu shoppingListMenu = applicationContext.getBean(ShoppingListMenu.class);
        PrintProductView printProductView = applicationContext.getBean(PrintProductView.class);
        AddProductView addProductView = applicationContext.getBean(AddProductView.class);
        RemoveProductView removeProductView = applicationContext.getBean(RemoveProductView.class);

        while (true) {
            String menuNumber = shoppingListMenu.execute();
            if (menuNumber.equals("1")) {
                printProductView.execute(shoppingList);
            } else if (menuNumber.equals("2")) {
                addProductView.execute(shoppingList);
            } else if (menuNumber.equals("3")) {
                removeProductView.execute(shoppingList);
            } else if (menuNumber.equals("4")) {
                System.out.println("-------------------------");
                System.out.println("Goodbye!");
                System.out.println("-------------------------");
                break;
            } else {
                System.out.println("-------------------------");
                System.out.println("Incorrect data input!");
                System.out.println("-------------------------");
            }
        }
    }
}

