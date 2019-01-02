package shoppinglist.menus;

import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class UserMenu implements Menu{

    @Override
    public String execute() {
        System.out.println("What do You want to do?");
        System.out.println("1. Show all shopping lists");
        System.out.println("2. Edit shopping list");
        System.out.println("3. Add shopping list");
        System.out.println("4. Remove shopping list");
        System.out.println("5. Go back");
        System.out.println("Type the number to choose.");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
