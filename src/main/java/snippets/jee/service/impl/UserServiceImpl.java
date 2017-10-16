package snippets.jee.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import snippets.jee.bean.User;
import snippets.jee.persistence.UserDAO;
import snippets.jee.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
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

    @Override
    public boolean register(User user) {
        return false;
    }
}
