package shoppinglist.menus;

import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class EnterMenu implements Menu{

    public String execute() {
        System.out.println("What do You want to do?");
        System.out.println("1. Log In");
        System.out.println("2. Create New User");
        System.out.println("3. Exit program");
        System.out.println("Type the number to choose.");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
