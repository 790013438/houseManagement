package snippets.jee.persistence;

import java.util.List;

import snippets.jee.entity.HouseType;

public interface HouseTypeDAO extends BaseDAO<HouseType, Integer> {

    List<HouseType> getHouseTypes();

}
