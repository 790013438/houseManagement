package snippets.jee.persistence;

import java.io.Serializable;

import snippets.jee.bean.User;

public interface UserDAO extends Serializable {

    public boolean save (User user);

    public boolean register (User user);

    public User findByUsername (String name);
}
