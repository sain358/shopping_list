package shoppinglist.views;

import java.util.Scanner;

public class MenuView {

    public String execute() {
        System.out.println("What do You want to do?");
        System.out.println("1. Show shopping list");
        System.out.println("2. Add product to shopping list");
        System.out.println("3. Remove product to shopping list");
        System.out.println("4. Exit from shopping list");
        System.out.println("Type the number to choose.");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
