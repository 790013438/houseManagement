package snippets.jee.persistence;

import java.util.List;

import snippets.jee.entity.City;
import snippets.jee.entity.District;

public interface DistrictDAO extends BaseDAO<District, Integer>{

    List<District> findAllByCity(City city);

}
