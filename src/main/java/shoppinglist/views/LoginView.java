package shoppinglist.views;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import shoppinglist.domains.User;
import shoppinglist.services.ShoppingListError;
import shoppinglist.services.users.get.GetUserRequest;
import shoppinglist.services.users.get.GetUserResponse;
import shoppinglist.services.users.get.GetUserService;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@Component
public class LoginView {

    @Autowired
    private GetUserService getUserService;

    public Optional<User> execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter LOGIN: ");
        String login = scanner.nextLine();
        System.out.println("Enter PASSWORD: ");
        String password = scanner.nextLine();

        GetUserRequest getUserRequest = new GetUserRequest(login, password);
        GetUserResponse getUserResponse = getUserService.execute(getUserRequest);

        List<ShoppingListError> shoppingListErrors = getUserResponse.getShoppingListErrors();
        if (!shoppingListErrors.isEmpty()) {
            printErrors(shoppingListErrors);
        }

        return Optional.ofNullable(getUserResponse.getUser());
    }

    public void printErrors(List<ShoppingListError> shoppingListErrors) {
        for (ShoppingListError shoppingListError : shoppingListErrors) {
            System.out.println(shoppingListError.getDescription());
        }
        System.out.println("-------------------------");
    }

}
