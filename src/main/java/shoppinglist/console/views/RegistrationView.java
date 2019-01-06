package shoppinglist.console.views;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import shoppinglist.console.domains.User;
import shoppinglist.console.services.ShoppingListError;
import shoppinglist.console.services.users.registration.UserRegistrationRequest;
import shoppinglist.console.services.users.registration.UserRegistrationResponse;
import shoppinglist.console.services.users.registration.UserRegistrationService;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@Component
public class RegistrationView {

    @Autowired
    private UserRegistrationService userRegistrationService;

    public Optional<User> execute() {
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
        }

        return Optional.ofNullable(userRegistrationResponse.getUser());
    }

    public void printErrors(List<ShoppingListError> shoppingListErrors) {
        for (ShoppingListError shoppingListError : shoppingListErrors) {
            System.out.println(shoppingListError.getDescription());
        }
        System.out.println("-------------------------");
    }

}
