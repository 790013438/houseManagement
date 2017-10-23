package snippets.jee.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import snippets.jee.entity.City;
import snippets.jee.entity.District;
import snippets.jee.entity.Province;
import snippets.jee.persistence.CityDAO;
import snippets.jee.persistence.DistrictDAO;
import snippets.jee.persistence.ProvinceDAO;
import snippets.jee.service.LocationService;

@Service
@Transactional(readOnly = true)
public class LocationServiceImpl implements LocationService {

    @Autowired
    private ProvinceDAO provinceDAO;

    @Autowired
    private CityDAO cityDAO;

    @Autowired
    private DistrictDAO districtDAO;

    @Override
    public List<City> listAllCitiesByProvince(Province province) {
        return cityDAO.findAllByProvince(province);
    }

    @Override
    public List<Province> listAllProvinces() {
        return provinceDAO.findAll();
    }

    @Override
    public List<District> listAllDistrictsByCity(City city) {
        return districtDAO.findAllByCity(city);
    }
}
