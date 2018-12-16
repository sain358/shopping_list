package shoppinglist.services.products.add;

public class AddProductRequest {

    private String productTitle;
    private String productDescription;

    public AddProductRequest(String productTitle, String productDescription) {
        this.productTitle = productTitle;
        this.productDescription = productDescription;
    }

    public String getProductTitle() {
        return productTitle;
    }

    public String getProductDescription() {
        return productDescription;
    }

}
