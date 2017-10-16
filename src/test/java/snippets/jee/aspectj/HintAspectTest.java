package snippets.jee.aspectj;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:app.xml")
public class HintAspectTest {

    @Autowired
    private Ultraman ultraman;

    @Test
    public void testBeforeAttack() {
        ultraman.attack();
    }
}
