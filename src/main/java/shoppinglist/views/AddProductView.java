package shoppinglist.views;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import shoppinglist.services.products.add.AddProductRequest;
import shoppinglist.services.products.add.AddProductResponse;
import shoppinglist.services.products.add.AddProductService;
import shoppinglist.services.ShoppingListError;

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

        List<ShoppingListError> shoppingListErrors = addProductResponse.getShoppingListErrors();
        if (!shoppingListErrors.isEmpty()) {
            printErrors(shoppingListErrors);
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
