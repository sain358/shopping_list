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
class UserRegistrationService {

    @Autowired
    private UserRegistrationValidator validator;
    @Autowired
    private UserRepository userRepository;

    public UserRegistrationResponse register(UserRegistrationRequest request) {

        List<ShoppingListError> validationErrors = validator.validate(request);
        if (!validationErrors.isEmpty()) {
            return new UserRegistrationResponse(validationErrors);
        }

        User user = new User();
        user.setLogin(request.getLogin());
        user.setPassword(request.getPassword());
        userRepository.save(user);

        return new UserRegistrationResponse(user.getId());
    }

}
