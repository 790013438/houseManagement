package snippets.jee.persistence.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import snippets.jee.entity.City;
import snippets.jee.entity.Province;
import snippets.jee.persistence.CityDAO;

@Repository
public class CityDAOImpl extends BaseDAOAdapter<City, Integer> implements CityDAO {

    @Override
    public List<City> findAllByProvince(Province province) {
        return sessionFactory.getCurrentSession()
            .createQuery("from City as c where c.province=:province", City.class)
            .setParameter("province", province)
            .getResultList();
    }

    
}
