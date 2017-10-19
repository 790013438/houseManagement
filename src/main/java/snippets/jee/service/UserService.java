package snippets.jee.service;

import snippets.jee.entity.User;

public interface UserService {

    boolean login (User user);

    boolean register (User user);

}
