package shoppinglist.services.remove;

public class RemoveProductRequest {

    private String productTitle;

    public RemoveProductRequest(String productTitle) {
        this.productTitle = productTitle;
    }

    public String getProductTitle() {
        return productTitle;
    }

}
