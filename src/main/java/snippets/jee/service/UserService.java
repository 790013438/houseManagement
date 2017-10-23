package snippets.jee.service;

import snippets.jee.dto.UserLoginDTO;
import snippets.jee.entity.User;

public interface UserService {

    boolean login (UserLoginDTO user);

    boolean register (User user);

    boolean checkUnique(String username);

}
