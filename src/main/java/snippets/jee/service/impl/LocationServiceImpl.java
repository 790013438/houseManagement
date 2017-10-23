package snippets.jee.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import snippets.jee.entity.City;
import snippets.jee.entity.Province;
import snippets.jee.persistence.ProvinceDAO;
import snippets.jee.service.LocationService;

@Service
@Transactional(readOnly = true)
public class LocationServiceImpl implements LocationService {

    @Autowired
    private ProvinceDAO provinceDAO;

    public void getLocations () {
        provinceDAO.getLocations();
    }

    @Override
    public List<City> listAllCitiesByProvince(Province province) {
        return null;
    }
}
