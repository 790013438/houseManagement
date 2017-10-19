package snippets.jee.persistence;

import snippets.jee.entity.User;

public interface UserDAO extends BaseDAO<User, Integer> {

    User findByUsername (String username);
}
