package snippets.jee.service.impl;

import snippets.jee.bean.User;
import snippets.jee.persistence.UserDAO;
import snippets.jee.service.UserService;

public class UserServiceImpl implements UserService {

    private UserDAO userDAO;

    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public boolean login (String username, String password) {
        User temp = userDAO.findByUsername(username);
        if (temp != null) {
            return temp.getPassword().equals(password);
        }
        return false;
    }
}
