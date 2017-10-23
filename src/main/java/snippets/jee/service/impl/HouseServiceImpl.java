package snippets.jee.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import snippets.jee.entity.HouseType;
import snippets.jee.persistence.HouseTypeDAO;
import snippets.jee.service.HouseService;

@Service
public class HouseServiceImpl implements HouseService {

    @Autowired
    private HouseTypeDAO houseTypeDAO;

    @Override
    public List<HouseType> listAllHouseTypes() {
        return houseTypeDAO.getHouseTypes();
    }

}
