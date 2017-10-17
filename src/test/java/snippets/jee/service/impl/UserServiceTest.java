package snippets.jee.service.impl;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import snippets.jee.entity.User;

public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void testRegister() {
        User user = new User();
        user.setUsername("jackfrued");
        user.setPassword("123123");
        user.setTel("12341234");
        Assert.assertFalse(userService.register(user));
    }
}
