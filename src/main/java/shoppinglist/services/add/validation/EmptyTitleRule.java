package shoppinglist.services.add.validation;

import org.springframework.stereotype.Component;
import shoppinglist.services.Error;

import java.util.Optional;

@Component
public class EmptyTitleRule {

    public Optional<Error> execute(String title) {
        if (title == null || title.isEmpty()) {
            Error error = new Error("title", "Empty title not allowed!");
            return Optional.of(error);
        } else {
            return Optional.empty();
        }
    }
}
