package snippets.jee.service;

import java.util.List;

import snippets.jee.dto.PageBean;
import snippets.jee.entity.House;
import snippets.jee.entity.HouseType;

public interface HouseService {

    List<HouseType> listAllHouseTypes();

    boolean publishNewHouse(House house);

    PageBean<House> listHousesByPage(int page, int size);
}
