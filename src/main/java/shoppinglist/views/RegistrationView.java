package shoppinglist.views;

import org.springframework.stereotype.Component;
import shoppinglist.services.ShoppingListError;
import shoppinglist.services.users.registration.UserRegistrationRequest;
import shoppinglist.services.users.registration.UserRegistrationResponse;
import shoppinglist.services.users.registration.UserRegistrationService;

import java.util.List;
import java.util.Scanner;

@Component
public class RegistrationView implements View{

    private UserRegistrationService userRegistrationService;

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter LOGIN: ");
        String login = scanner.nextLine();
        System.out.println("Enter PASSWORD: ");
        String password1 = scanner.nextLine();
        System.out.println("Repeat PASSWORD: ");
        String password2 = scanner.nextLine();

        UserRegistrationRequest userRegistrationRequest = new UserRegistrationRequest(login, password1, password2);
        UserRegistrationResponse userRegistrationResponse = userRegistrationService.execute(userRegistrationRequest);

        List<ShoppingListError> shoppingListErrors = userRegistrationResponse.getShoppingListErrors();
        if (!shoppingListErrors.isEmpty()) {
            printErrors(shoppingListErrors);
        } else {

        }

    }

    @Override
    public void printErrors(List<ShoppingListError> shoppingListErrors) {
        for (ShoppingListError shoppingListError : shoppingListErrors) {
            System.out.println(shoppingListError.getDescription());
        }
        System.out.println("-------------------------");
    }

}
