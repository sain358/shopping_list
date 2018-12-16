package shoppinglist.services;

import org.springframework.stereotype.Component;

public class ShoppingListError {

    private String field;
    private String description;

    public ShoppingListError(String field, String description) {
        this.field = field;
        this.description = description;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}