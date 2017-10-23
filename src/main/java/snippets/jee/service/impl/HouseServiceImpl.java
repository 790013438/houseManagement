package snippets.jee.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import snippets.jee.entity.HouseType;
import snippets.jee.persistence.HouseTypeDAO;
import snippets.jee.service.HouseService;

@Service
public class HouseServiceImpl implements HouseService {

    @Autowired
    private HouseTypeDAO houseTypeDAO;

    @Transactional(readOnly = true)
    @Override
    public List<HouseType> listAllHouseTypes() {
        return houseTypeDAO.findAll();
    }

}
