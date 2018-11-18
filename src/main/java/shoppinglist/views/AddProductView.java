package shoppinglist.views;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import shoppinglist.services.add.AddProductRequest;
import shoppinglist.services.add.AddProductResponse;
import shoppinglist.services.add.AddProductService;
import shoppinglist.services.Error;

import java.util.List;
import java.util.Scanner;

@Component
public class AddProductView implements View {

    @Autowired
    private AddProductService addProductService;

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("-------------------------");
        System.out.println("Type the product title:");
        String productTitle = scanner.nextLine();
        System.out.println("Type the product description:");
        String productDescription = scanner.nextLine();
        System.out.println("-------------------------");

        AddProductRequest addProductRequest = new AddProductRequest(productTitle, productDescription);
        AddProductResponse addProductResponse = addProductService.execute(addProductRequest);

        List<Error> errors = addProductResponse.getErrors();
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
