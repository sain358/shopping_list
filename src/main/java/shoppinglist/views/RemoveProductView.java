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
        System.out.println("Type the product ID:");
        Scanner scanner = new Scanner(System.in);
        Long productID = scanner.nextLong();
        removeProductService.execute(productID);
    }
}
