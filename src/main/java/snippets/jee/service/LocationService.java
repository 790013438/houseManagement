package snippets.jee.service;

import java.util.List;

import snippets.jee.entity.City;
import snippets.jee.entity.District;
import snippets.jee.entity.Province;

public interface LocationService {

    List<Province> listAllProvinces();

    List<City> listAllCitiesByProvince(Province province);

    List<District> listAllDistrictsByCity(City city);

}
