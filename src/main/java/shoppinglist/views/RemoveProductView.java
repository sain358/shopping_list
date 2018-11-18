package shoppinglist.views;

import org.springframework.stereotype.Component;
import shoppinglist.services.Error;
import shoppinglist.services.remove.RemoveProductRequest;
import shoppinglist.services.remove.RemoveProductResponse;
import shoppinglist.services.remove.RemoveProductService;

import java.util.List;
import java.util.Scanner;

@Component
public class RemoveProductView implements View {

    private RemoveProductService removeProductService;

    public RemoveProductView(RemoveProductService removeProductService) {
        this.removeProductService = removeProductService;
    }

    @Override
    public void execute() {
        System.out.println("-------------------------");
        System.out.println("Type the product title:");
        Scanner scanner = new Scanner(System.in);
        String title = scanner.nextLine();
        System.out.println("-------------------------");

        RemoveProductRequest removeProductRequest = new RemoveProductRequest(title);
        RemoveProductResponse removeProductResponse = removeProductService.execute(removeProductRequest);

        List<Error> errors = removeProductResponse.getErrors();
        if (!errors.isEmpty()) {
            printErrors(errors);
        }
    }

    private void printErrors(List<Error> errors) {
        for (Error error : errors) {
            System.out.println(error.getDescription());
        }
        System.out.println("-------------------------");
    }

}

