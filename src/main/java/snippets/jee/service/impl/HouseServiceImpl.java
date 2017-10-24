package snippets.jee.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import snippets.jee.dto.PageBean;
import snippets.jee.entity.House;
import snippets.jee.entity.HouseType;
import snippets.jee.persistence.HouseDAO;
import snippets.jee.persistence.HouseTypeDAO;
import snippets.jee.service.HouseService;

@Service
public class HouseServiceImpl implements HouseService {

    @Autowired
    private HouseTypeDAO houseTypeDAO;

    @Autowired
    private HouseDAO houseDAO;

    @Transactional(readOnly = true)
    @Override
    public List<HouseType> listAllHouseTypes() {
        return houseTypeDAO.findAll();
    }

    @Transactional
    @Override
    public boolean publishNewHouse(House house) {
        return houseDAO.save(house) != null;
    }

    @Transactional(readOnly = true)
    @Override
    public PageBean<House> listHousesByPage(int page, int size) {
        return houseDAO.findByPage(page, size);
    }

}
