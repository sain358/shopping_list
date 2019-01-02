package shoppinglist;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import shoppinglist.configs.SpringConfig;
import shoppinglist.domains.ShoppingList;
import shoppinglist.domains.User;
import shoppinglist.menus.EnterMenu;
import shoppinglist.menus.ShoppingListMenu;
import shoppinglist.menus.UserMenu;
import shoppinglist.views.*;

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
        enterMenuActions();

    }

    private static void enterMenuActions() {
        while (true) {
            String menuNumber = enterMenu.execute();
            if (menuNumber.equals("1")) {
                Optional<User> optionalUser = loginView.execute();
                if (optionalUser.isPresent()) {
                    user = optionalUser.get();
                    userMenuActions();
                }
            } else if (menuNumber.equals("2")) {
                Optional<User> optionalUser = registrationView.execute();
                if (optionalUser.isPresent()) {
                    user = optionalUser.get();
                    userMenuActions();
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

    private static void userMenuActions() {
        while (true) {
            String menuNumber = userMenu.execute();
            if (menuNumber.equals("1")) {
                printShoppingListsView.execute(user);
            } else if (menuNumber.equals("2")) {
                Optional<ShoppingList> optionalShoppingList = editShoppingListView.execute(user);
                if (optionalShoppingList.isPresent()) {
                    shoppingList = optionalShoppingList.get();
                    shoppingListMenuActions();
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

    private static void shoppingListMenuActions() {
        while (true) {
            String menuNumber = shoppingListMenu.execute();
            if (menuNumber.equals("1")) {
                printProductView.execute();
            } else if (menuNumber.equals("2")) {
                addProductView.execute();
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

