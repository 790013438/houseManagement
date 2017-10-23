package snippets.jee.persistence.impl;

import org.springframework.stereotype.Repository;

import snippets.jee.entity.Province;
import snippets.jee.persistence.ProvinceDAO;

@Repository
public class ProvinceDAOImpl extends BaseDAOAdapter<Province, Integer> implements ProvinceDAO {

    @Override
    public void getLocations() {
    }
}
