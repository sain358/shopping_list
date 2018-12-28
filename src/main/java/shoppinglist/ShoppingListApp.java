package shoppinglist;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import shoppinglist.configs.SpringConfig;
import shoppinglist.views.AddProductView;
import shoppinglist.views.PrintProductView;
import shoppinglist.views.RemoveProductView;
import shoppinglist.menus.ShoppingListMenu;

public class ShoppingListApp {

    public static void main(String[] args) {

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);

        ShoppingListMenu shoppingListMenu = applicationContext.getBean(ShoppingListMenu.class);
        PrintProductView printProductView = applicationContext.getBean(PrintProductView.class);
        AddProductView addProductView = applicationContext.getBean(AddProductView.class);
        RemoveProductView removeProductView = applicationContext.getBean(RemoveProductView.class);

        while (true) {
            String menuNumber = shoppingListMenu.execute();
            if (menuNumber.equals("1")) {
                printProductView.execute();
            } else if (menuNumber.equals("2")) {
                addProductView.execute();
            } else if (menuNumber.equals("3")) {
                removeProductView.execute();
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

