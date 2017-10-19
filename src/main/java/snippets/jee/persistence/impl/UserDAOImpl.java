package snippets.jee.persistence.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import snippets.jee.entity.User;
import snippets.jee.persistence.UserDAO;

@Repository
public class UserDAOImpl extends BaseDAOAdapter<User, Integer> implements UserDAO {

    @Override
    public User findByUsername (String username) {
        List<User> userList = sessionFactory.getCurrentSession()
                .createQuery("from User as u where u.username=:username", User.class)
                .setParameter("username", username)
                .getResultList();
        return userList.size() == 1 ? userList.get(0) : null;
    }
}
