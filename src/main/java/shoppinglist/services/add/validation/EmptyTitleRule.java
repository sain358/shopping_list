package shoppinglist.services.add.validation;

import org.springframework.stereotype.Component;
import shoppinglist.services.Error;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class EmptyTitleRule {

    public Optional<Error> execute(String title) {
        Pattern pattern = Pattern.compile("^\\s*$");
        Matcher matcher = pattern.matcher(title);
        if (title == null || matcher.find()) {
            Error error = new Error("title", "Empty title not allowed!");
            return Optional.of(error);
        }
        return Optional.empty();
    }
}
