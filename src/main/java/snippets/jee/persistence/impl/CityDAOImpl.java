package snippets.jee.persistence.impl;

import org.springframework.stereotype.Repository;

import snippets.jee.entity.City;
import snippets.jee.persistence.CityDAO;

@Repository
public class CityDAOImpl extends BaseDAOAdapter<City, Integer> implements CityDAO {

    
}
