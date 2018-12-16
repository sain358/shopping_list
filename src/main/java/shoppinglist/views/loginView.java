package shoppinglist.views;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import shoppinglist.services.ShoppingListError;
import shoppinglist.services.users.get.GetUserRequest;
import shoppinglist.services.users.get.GetUserResponse;
import shoppinglist.services.users.get.GetUserService;

import java.util.List;
import java.util.Scanner;

@Component
public class loginView implements View{

    @Autowired
    private GetUserService getUserService;

    @Override
    public void execute() {
        while (true) {
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
            } else {
                //idem v bazu dlja polu4enija spiska vseh Shopoing listov Usera
            }
        }

    }

    private void printErrors(List<ShoppingListError> shoppingListErrors) {
        for (ShoppingListError shoppingListError : shoppingListErrors) {
            System.out.println(shoppingListError.getDescription());
        }
        System.out.println("-------------------------");
    }

}
