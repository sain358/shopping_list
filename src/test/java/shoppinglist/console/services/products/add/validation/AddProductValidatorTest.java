package shoppinglist.console.services.products.add.validation;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import shoppinglist.console.domains.ShoppingList;
import shoppinglist.console.services.ShoppingListError;
import shoppinglist.console.services.products.add.AddProductRequest;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class AddProductValidatorTest {

    @Mock
    private EmptyTitleRule emptyTitleRule;

    @Mock
    private UniqueProductRule uniqueProductRule;

    @Mock
    private ShoppingListExistenceAddRule shoppingListExistenceAddRule;

    @InjectMocks
    private AddProductValidator validator = new AddProductValidator();

    @Test
    public void mustReturnListOfErrorsIfThereIsSomeError() {
        Mockito.when(emptyTitleRule.execute("someTitle")).
                thenReturn(Optional.empty());

        List<ShoppingListError> shoppingListErrors = validator.validate(
                new AddProductRequest("someTitle", "someDescription", 1, new ShoppingList()));

        assertEquals(0, shoppingListErrors.size());
    }

    @Test
    public void mustReturnEmptyListOfErrorsIfThereNoAnyError() {
        Mockito.when(emptyTitleRule.execute("someTitle")).
                thenReturn(Optional.of(new ShoppingListError("someTitle","someDescription")));

        List<ShoppingListError> shoppingListErrors = validator.validate(
                new AddProductRequest("someTitle", "someDescription", 1, new ShoppingList()));

        assertEquals(1, shoppingListErrors.size());
    }

}