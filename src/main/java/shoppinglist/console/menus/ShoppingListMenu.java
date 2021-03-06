package shoppinglist.console.menus;

import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class ShoppingListMenu implements Menu{

    @Override
    public String execute() {
        System.out.println("What do You want to do?");
        System.out.println("1. Show shopping list");
        System.out.println("2. Add product to shopping list");
        System.out.println("3. Remove product from shopping list");
        System.out.println("4. Go back");
        System.out.println("Type the number to choose.");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
