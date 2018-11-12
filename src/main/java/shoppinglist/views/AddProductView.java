package shoppinglist.views;

import org.springframework.stereotype.Component;
import shoppinglist.services.AddProductService;

import java.util.Scanner;

@Component
public class AddProductView implements View {

    private AddProductService addProductService;

    public AddProductView(AddProductService addProductService) {
        this.addProductService = addProductService;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("-------------------------");
        System.out.println("Type the product title:");
        String productTitle = scanner.nextLine();
        System.out.println("Type the product description:");
        String productDescription = scanner.nextLine();
        System.out.println("-------------------------");
        if (addProductService.execute(productTitle, productDescription)) {
            System.out.println("Incorrect data input!");
            System.out.println("-------------------------");
        }
    }

}
