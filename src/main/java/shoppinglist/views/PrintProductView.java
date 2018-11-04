package shoppinglist.views;

import shoppinglist.services.PrintProductService;

public class PrintProductView implements View {

    private PrintProductService printProductService;

    public PrintProductView(PrintProductService printProductService) {
        this.printProductService = printProductService;
    }

    @Override
    public void execute() {
        System.out.println("This is Your shopping list:");
        printProductService.execute();
        System.out.println();
    }

}
