package shoppinglist.services.users.registration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import shoppinglist.database.UserRepository;
import shoppinglist.domains.User;
import shoppinglist.services.ShoppingListError;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
class UserRegistrationValidator {

    @Autowired
    private UserRepository userRepository;

    public List<ShoppingListError> validate(UserRegistrationRequest request) {
        List<ShoppingListError> errors = new ArrayList<>();
        validateLogin(request.getLogin()).ifPresent(errors::add);
        validateDuplicateLogin(request.getLogin()).ifPresent(errors::add);
        validatePassword(request.getPassword()).ifPresent(errors::add);
        return errors;
    }

    private Optional<ShoppingListError> validateLogin(String login) {
        Pattern pattern = Pattern.compile("^\\s*$");
        Matcher matcher = pattern.matcher(login);
        if (matcher.find()) {
            return Optional.of(new ShoppingListError("login", "Empty login not allowed!"));
        }
        return Optional.empty();

    }

    private Optional<ShoppingListError> validatePassword(String password) {
        Pattern pattern = Pattern.compile("^\\s*$");
        Matcher matcher = pattern.matcher(password);
        if (matcher.find()) {
            return Optional.of(new ShoppingListError("password", "Empty password not allowed!"));
        }
        return Optional.empty();

    }

    private Optional<ShoppingListError> validateDuplicateLogin(String login) {
        if (login != null) {
            Optional<User> user = userRepository.findByLogin(login);
            if (user.isPresent()) {
                return Optional.of(new ShoppingListError("login", "This user already exists!"));
            }
        }
        return Optional.empty();
    }

}