package shoppinglist.views;

import shoppinglist.services.AddProductService;

import java.util.Scanner;

public class AddProductView implements View {

    private AddProductService addProductService;

    public AddProductView(AddProductService addProductService) {
        this.addProductService = addProductService;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Type the product title:");
        String productTitle = scanner.nextLine();
        System.out.println("Type the product description:");
        String productDescription = scanner.nextLine();
        addProductService.execute(productTitle, productDescription);

    }

}
