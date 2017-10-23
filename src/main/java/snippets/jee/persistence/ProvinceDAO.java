package snippets.jee.persistence;

import snippets.jee.entity.Province;

public interface ProvinceDAO extends BaseDAO<Province, Integer> {

    void getLocations();

}
