package shoppinglist.services.products.add.validation;

import org.junit.Test;
import org.mockito.Mockito;
import shoppinglist.database.ProductRepository;
import shoppinglist.domains.Product;
import shoppinglist.services.ShoppingListError;

import java.util.Optional;

import static org.junit.Assert.*;

public class TheSameProductTitleRuleTest {

    private ProductRepository repository;
    private TheSameProductTitleRule rule;
    private Product product;

    {
        repository = Mockito.mock(ProductRepository.class);
        rule = new TheSameProductTitleRule(repository);
        product = new Product();
    }

    @Test
    public void mustNotReturnErrorIfTitleIsUnique() {
        Mockito.when(repository.findProductByTitle("title")).thenReturn(Optional.empty());

        Optional<ShoppingListError> error = rule.execute("title");

        assertFalse(error.isPresent());
    }

    @Test
    public void mustReturnErrorIfTitleIsNotUnique() {
        Mockito.when(repository.findProductByTitle("someTitle")).thenReturn(Optional.of(product));

        Optional<ShoppingListError> error = rule.execute("someTitle");

        assertTrue(error.isPresent());
        assertEquals("title", error.get().getField());
        assertEquals("Same title not allowed!", error.get().getDescription());
    }

}