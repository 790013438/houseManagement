package snippets.jee.persistence.impl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import snippets.jee.entity.JPAEntityFactoryBean;
import snippets.jee.entity.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:app.xml")
public class UserDAOImplTest {

    @Autowired
    private JPAEntityFactoryBean entityFactoryBean;

    @Test
    public void testUpdate() {
        //Get entity manager
        EntityManagerFactory entityManagerFactory = entityFactoryBean.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        User user = new User();
        user.setId(3);
        user.setUsername("1");
        user.setPassword(DigestUtils.md5Hex("111111"));
        user.setRealname("1");

        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        entityManager.merge(user);
        entityTransaction.commit();
    }
}
