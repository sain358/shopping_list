package shoppinglist.services.users.registration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import shoppinglist.database.UserRepository;
import shoppinglist.domains.User;
import shoppinglist.services.ShoppingListError;

import javax.transaction.Transactional;
import java.util.List;

@Component
@Transactional
public class UserRegistrationService {

    @Autowired
    private UserRegistrationValidator validator;

    @Autowired
    private UserRepository userRepository;

    public UserRegistrationResponse execute(UserRegistrationRequest request) {

        UserRegistrationResponse response = new UserRegistrationResponse();

        List<ShoppingListError> validationErrors = validator.validate(request);
        response.setShoppingListErrors(validationErrors);
        if (!validationErrors.isEmpty()) {
            return response;
        }

        User user = new User();
        user.setLogin(request.getLogin());
        user.setPassword(request.getPassword());
        userRepository.save(user);

        response.setUser(user);
        return response;
    }

}
