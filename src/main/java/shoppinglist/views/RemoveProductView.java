package shoppinglist.views;

import shoppinglist.services.RemoveProductService;

import java.util.Scanner;

public class RemoveProductView implements View {

    private RemoveProductService removeProductService;

    public RemoveProductView(RemoveProductService removeProductService) {
        this.removeProductService = removeProductService;
    }

    @Override
    public void execute() {
        System.out.println("Type the product title:");
        Scanner scanner = new Scanner(System.in);
        String productTitle = scanner.nextLine();
        removeProductService.execute(productTitle);
    }
}
