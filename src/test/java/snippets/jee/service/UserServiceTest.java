package snippets.jee.service;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(location = "classpath:app.xml")
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void testLoginAndRegister() {
        userServlet.login("admin", "123456");
        userServlet.register(null);
    }
}
