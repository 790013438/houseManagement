package snippets.jee.persistence;

import java.util.List;

import snippets.jee.entity.City;
import snippets.jee.entity.Province;

public interface CityDAO extends BaseDAO<City, Integer> {

    List<City> findAllByProvince(Province province);

}
