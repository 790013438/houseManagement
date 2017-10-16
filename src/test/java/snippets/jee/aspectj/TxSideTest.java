package snippets.jee.aspectj;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import snippets.jee.mock.dao.UserDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:app.xml")
public class TxSideTest {

    @Autowired
    private UserDAO userDAO;

    @Test
    public void testDoTransaction() {
        userDAO.insert();
    }

    @Test(expected = Throwable.class)
    public void testHaha() {
        userDAO.mock();
    }
}
