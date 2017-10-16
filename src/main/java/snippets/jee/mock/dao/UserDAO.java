package snippets.jee.mock.dao;

import org.springframework.stereotype.Component;

@Component
public class UserDAO {

    public void insert() {
    }

    public void getUsers() {
    }

    public void mock () {
        throw new RuntimeException();
    }
}
