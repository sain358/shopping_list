package shoppinglist.console.services.users.get;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import shoppinglist.console.database.UserRepository;
import shoppinglist.console.domains.User;
import shoppinglist.console.services.ShoppingListError;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Component
@Transactional
public class GetUserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private GetUserValidator validator;

    public GetUserResponse execute(GetUserRequest request) {

        GetUserResponse response = new GetUserResponse();

        List<ShoppingListError> shoppingListErrors = validator.validate(request);
        response.setShoppingListErrors(shoppingListErrors);
        if (!shoppingListErrors.isEmpty()) {
            return response;
        }

        Optional<User> userOptional = userRepository.findByLoginAndPassword(request.getLogin(), request.getPassword());
        User user = new User();
        if (userOptional.isPresent()) {
            user = userOptional.get();
        }

        response.setUser(user);
        return response;
    }

}