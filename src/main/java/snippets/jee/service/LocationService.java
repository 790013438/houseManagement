package snippets.jee.service;

import java.util.List;

import snippets.jee.entity.City;
import snippets.jee.entity.Province;

public interface LocationService {

    List<City> listAllCitiesByProvince(Province province);

}
