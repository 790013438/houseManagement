package snippets.jee.persistence;

import snippets.jee.dto.PageBean;
import snippets.jee.entity.House;

public interface HouseDAO extends BaseDAO<House, Integer> {

    PageBean<House> findByPage(int page, int size);

}
