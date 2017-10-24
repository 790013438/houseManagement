package snippets.jee.persistence.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import snippets.jee.dto.PageBean;
import snippets.jee.entity.House;
import snippets.jee.persistence.HouseDAO;

@Repository
public class HouseDAOImpl extends BaseDAOAdapter<House, Integer> implements HouseDAO {

    @Override
    public PageBean<House> findByPage (int page, int size) {
        List<House> dataModel = sessionFactory.getCurrentSession()
            .createQuery("from House as h order by h.pubDate desc", House.class)
            .setFirstResult((page - 1) * size)
            .setMaxResults(size)
            .getResultList();

        int count = sessionFactory.getCurrentSession()
            .createQuery("select count(h) from House as h", Long.class)
            .getSingleResult().intValue();
        int totalPage = (count - 1) / size + 1;
        return new PageBean<>(dataModel, totalPage, page, size);
    }

}
