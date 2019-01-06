package shoppinglist.console;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import shoppinglist.console.config.SpringConfig;
import shoppinglist.console.domains.ShoppingList;
import shoppinglist.console.domains.User;
import shoppinglist.console.menus.EnterMenu;
import shoppinglist.console.menus.ShoppingListMenu;
import shoppinglist.console.menus.UserMenu;
import shoppinglist.console.views.*;
import shoppinglist.web.config.SpringWebMvcConfig;
import shoppinglist.web.config.SpringWebMvcInitializer;

import java.util.Optional;

public class ShoppingListConsoleApp {
    private static User user = null;
    private static ShoppingList shoppingList = null;

    private static ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);

    private static EnterMenu enterMenu = applicationContext.getBean(EnterMenu.class);
    private static LoginView loginView = applicationContext.getBean(LoginView.class);
    private static RegistrationView registrationView = applicationContext.getBean(RegistrationView.class);

    private static UserMenu userMenu = applicationContext.getBean(UserMenu.class);
    private static PrintShoppingListsView printShoppingListsView = applicationContext.getBean(PrintShoppingListsView.class);
    private static EditShoppingListView editShoppingListView = applicationContext.getBean(EditShoppingListView.class);
    private static AddShoppingListView addShoppingListView = applicationContext.getBean(AddShoppingListView.class);
    private static RemoveShoppingListView removeShoppingListView = applicationContext.getBean(RemoveShoppingListView.class);


    private static ShoppingListMenu shoppingListMenu = applicationContext.getBean(ShoppingListMenu.class);
    private static PrintProductView printProductView = applicationContext.getBean(PrintProductView.class);
    private static AddProductView addProductView = applicationContext.getBean(AddProductView.class);
    private static RemoveProductView removeProductView = applicationContext.getBean(RemoveProductView.class);


    public static void main(String[] args) {
        enterActions();

    }

    private static void enterActions() {
        while (true) {
            String menuNumber = enterMenu.execute();
            if (menuNumber.equals("1")) {
                Optional<User> optionalUser = loginView.execute();
                if (optionalUser.isPresent()) {
                    user = optionalUser.get();
                    userActions();
                }
            } else if (menuNumber.equals("2")) {
                Optional<User> optionalUser = registrationView.execute();
                if (optionalUser.isPresent()) {
                    user = optionalUser.get();
                    userActions();
                }
            } else if (menuNumber.equals("3")) {
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

    private static void userActions() {
        while (true) {
            String menuNumber = userMenu.execute();
            if (menuNumber.equals("1")) {
                printShoppingListsView.execute(user);
            } else if (menuNumber.equals("2")) {
                Optional<ShoppingList> optionalShoppingList = editShoppingListView.execute(user);
                if (optionalShoppingList.isPresent()) {
                    shoppingList = optionalShoppingList.get();
                    shoppingListActions();
                }
            } else if (menuNumber.equals("3")) {
                addShoppingListView.execute(user);
            } else if (menuNumber.equals("4")) {
                removeShoppingListView.execute(user);
            } else if (menuNumber.equals("5")) {
                break;
            } else {
                System.out.println("-------------------------");
                System.out.println("Incorrect data input!");
                System.out.println("-------------------------");
            }
        }

    }

    private static void shoppingListActions() {
        while (true) {
            String menuNumber = shoppingListMenu.execute();
            if (menuNumber.equals("1")) {
                printProductView.execute(shoppingList);
            } else if (menuNumber.equals("2")) {
                addProductView.execute(shoppingList);
            } else if (menuNumber.equals("3")) {
                removeProductView.execute();
            } else if (menuNumber.equals("4")) {
                break;
            } else {
                System.out.println("-------------------------");
                System.out.println("Incorrect data input!");
                System.out.println("-------------------------");
            }
        }

    }

}

