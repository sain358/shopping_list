package shoppinglist;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import shoppinglist.configs.SpringConfig;
import shoppinglist.views.AddProductView;
import shoppinglist.views.PrintProductView;
import shoppinglist.views.RemoveProductView;
import shoppinglist.views.MenuView;

public class ShoppingListApp {

    public static void main(String[] args) {

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);

        MenuView menuView = applicationContext.getBean(MenuView.class);
        PrintProductView printProductView = applicationContext.getBean(PrintProductView.class);
        AddProductView addProductView = applicationContext.getBean(AddProductView.class);
        RemoveProductView removeProductView = applicationContext.getBean(RemoveProductView.class);

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

