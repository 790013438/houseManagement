package snippets.jee.persistence.impl;

import snippets.jee.bean.User;
import snippets.jee.persistence.UserDAO;

public class UserDAOImpl implements UserDAO {

    private static final long serialVersionUID = 1L;

    @Override
    public boolean save(User user) {
        return false;
    }

    @Override
    public boolean register(User user) {
        return false;
    }

    @Override
    public User findByUsername(String name) {
        System.out.println("使用数据库查找对象");
        return null;
    }

}
