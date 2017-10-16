package snippets.jee.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import snippets.jee.bean.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:app.xml")
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Autowired
    private User user;

    @Test
    public void testLoginAndRegister() {
        userService.login("admin", "123456");
        userService.register(user);
    }
}
