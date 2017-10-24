package snippets.jee.persistence.impl;

import org.springframework.stereotype.Repository;

import snippets.jee.entity.House;
import snippets.jee.persistence.HouseDAO;

@Repository
public class HouseDAOImpl extends BaseDAOAdapter<House, Integer> implements HouseDAO {

}
