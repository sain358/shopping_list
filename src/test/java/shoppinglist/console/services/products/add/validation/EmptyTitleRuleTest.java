package shoppinglist.console.services.products.add.validation;

import org.junit.Test;
import shoppinglist.console.services.ShoppingListError;

import java.util.Optional;

import static org.junit.Assert.*;

public class EmptyTitleRuleTest {

    private EmptyTitleRule rule = new EmptyTitleRule();

    @Test
    public void mustNotReturnErrorIfTitleIsNotEmpty() {
        Optional<ShoppingListError> error = rule.execute("someTitle");

        assertFalse(error.isPresent());
    }

    @Test
    public void mustReturnErrorIfTitleIsEmpty() {
        Optional<ShoppingListError> error = rule.execute("       ");

        assertTrue(error.isPresent());
        assertEquals("title", error.get().getPointer());
        assertEquals("Empty title not allowed!", error.get().getDescription());
    }

}