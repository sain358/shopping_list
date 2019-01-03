package shoppinglist.views;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import shoppinglist.domains.ShoppingList;
import shoppinglist.services.products.add.AddProductRequest;
import shoppinglist.services.products.add.AddProductResponse;
import shoppinglist.services.products.add.AddProductService;
import shoppinglist.services.ShoppingListError;

import java.util.List;
import java.util.Scanner;

@Component
public class AddProductView {

    @Autowired
    private AddProductService addProductService;

    public void execute(ShoppingList shoppingList) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("-------------------------");
        System.out.println("Type the product title:");
        String productTitle = scanner.nextLine();
        System.out.println("Type the product description:");
        String productDescription = scanner.nextLine();
        System.out.println("Type the product quantity:");
        Integer productQuantity = scanner.nextInt();
        System.out.println("-------------------------");

        AddProductRequest addProductRequest =
                new AddProductRequest(productTitle, productDescription, productQuantity, shoppingList);
        AddProductResponse addProductResponse = addProductService.execute(addProductRequest);

        List<ShoppingListError> shoppingListErrors = addProductResponse.getShoppingListErrors();
        if (!shoppingListErrors.isEmpty()) {
            printErrors(shoppingListErrors);
        }
    }

    public void printErrors(List<ShoppingListError> shoppingListErrors) {
        for (ShoppingListError shoppingListError : shoppingListErrors) {
            System.out.println(shoppingListError.getDescription());
        }
        System.out.println("-------------------------");
    }

}
