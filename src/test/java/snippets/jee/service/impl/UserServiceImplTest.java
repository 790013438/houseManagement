package snippets.jee.service.impl;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import snippets.jee.entity.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:app.xml")
public class UserServiceImplTest {

    @Autowired
    private UserServiceImpl userService;

    @Test
    public void testRegister() {
        User user = new User();
        user.setUsername("jackfrued");
        user.setPassword("123123");
        user.setTel("12341234");
        Assert.assertFalse(userService.register(user));
    }
}
