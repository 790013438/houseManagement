package snippets.jee.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import snippets.jee.entity.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:app.xml")
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void testLogin() {
        User user = new User();
        user.setUsername("hellokitty");
        user.setPassword("lqaz2wsx");
        userService.login(user);
    }

    @Test
    public void testRegister() {
        User user = new User();
        user.setUsername("two");
        user.setPassword("1qaz2wsx");
        user.setRealname("haha");
        user.setTel("13500998765");
        user.setAdmin(false);
        userService.register(user);
    }

}
