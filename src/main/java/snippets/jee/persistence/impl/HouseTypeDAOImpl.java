package snippets.jee.persistence.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import snippets.jee.entity.HouseType;
import snippets.jee.persistence.HouseTypeDAO;

@Repository
public class HouseTypeDAOImpl extends BaseDAOAdapter<HouseType, Integer> implements HouseTypeDAO {

    @Override
    public List<HouseType> getHouseTypes() {
        return null;
    }
}
