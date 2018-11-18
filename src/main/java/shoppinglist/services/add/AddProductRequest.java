package shoppinglist.services.add;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
