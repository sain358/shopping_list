package shoppinglist.services.users.get;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import shoppinglist.database.UserRepository;
import shoppinglist.domains.User;
import shoppinglist.services.ShoppingListError;

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

        List<ShoppingListError> shoppingListErrors = validator.validate(request);
        if (!shoppingListErrors.isEmpty()) {
            return new GetUserResponse(shoppingListErrors);
        }

        Optional<User> userOptional = userRepository.findByLoginAndPassword(request.getLogin(), request.getPassword());
        User user = new User();
        if (userOptional.isPresent()) {
            user = userOptional.get();
        }
        return new GetUserResponse(user);

    }

}