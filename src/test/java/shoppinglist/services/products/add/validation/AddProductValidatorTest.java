package shoppinglist.services.products.add.validation;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import shoppinglist.services.ShoppingListError;
import shoppinglist.services.products.add.AddProductRequest;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class AddProductValidatorTest {

    @Mock
    private EmptyTitleRule emptyTitleRule;

    @Mock
    private TheSameProductTitleRule theSameProductTitleRule;

    @InjectMocks
    private AddProductValidator validator = new AddProductValidator();

    @Test
    public void mustReturnListOfErrorsIfThereIsSomeError() {
        Mockito.when(emptyTitleRule.execute("someTitle")).
                thenReturn(Optional.empty());
        Mockito.when(theSameProductTitleRule.execute("someTitle")).
                thenReturn(Optional.empty());

        List<ShoppingListError> shoppingListErrors = validator.validate(
                new AddProductRequest("someTitle", "someDescription"));

        assertEquals(0, shoppingListErrors.size());
    }

    @Test
    public void mustReturnEmptyListOfErrorsIfThereNoAnyError() {
        Mockito.when(emptyTitleRule.execute("someTitle")).
                thenReturn(Optional.of(new ShoppingListError("someTitle","someDescription")));
        Mockito.when(theSameProductTitleRule.execute("someTitle")).
                thenReturn(Optional.of(new ShoppingListError("someTitle","someDescription")));

        List<ShoppingListError> shoppingListErrors = validator.validate(
                new AddProductRequest("someTitle", "someDescription"));

        assertEquals(2, shoppingListErrors.size());
    }

}