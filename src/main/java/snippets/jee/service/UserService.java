package snippets.jee.service;

import snippets.jee.bean.User;

public interface UserService {

    public boolean login (String username, String password);

    public boolean register (User user);
}
