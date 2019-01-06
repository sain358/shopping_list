package shoppinglist.console.services.users.get;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import shoppinglist.console.database.UserRepository;
import shoppinglist.console.domains.User;
import shoppinglist.console.services.ShoppingListError;
import shoppinglist.console.services.users.registration.UserRegistrationRequest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class GetUserValidator {

    @Autowired
    private UserRepository userRepository;

    public List<ShoppingListError> validate(GetUserRequest request) {
        List<ShoppingListError> errors = new ArrayList<>();

        Optional<ShoppingListError> errorOptional = validateUserCredentials(request.getLogin(), request.getPassword());
        errorOptional.ifPresent(errors::add);

        return errors;
    }

    private Optional<ShoppingListError> validateUserCredentials(String login, String password) {

        Optional<User> userOptional = userRepository.findByLoginAndPassword(login, password);

        if (!userOptional.isPresent()) {
            return Optional.of(new ShoppingListError("", "Wrong LOGIN or PASSWORD!"));
        }
        return Optional.empty();

    }

}
