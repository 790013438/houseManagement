package snippets.jee.persistence.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import snippets.jee.entity.City;
import snippets.jee.entity.District;
import snippets.jee.persistence.DistrictDAO;

@Repository
public class DistrictDAOImpl extends BaseDAOAdapter<District, Integer> implements DistrictDAO {

    @Override
    public List<District> findAllByCity (City city) {
        return sessionFactory.getCurrentSession()
            .createQuery("from District as d where d.city=:city", District.class)
            .setParameter("city", city)
            .getResultList();
    }

}
