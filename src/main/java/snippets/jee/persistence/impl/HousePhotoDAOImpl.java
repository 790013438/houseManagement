package snippets.jee.persistence.impl;

import org.springframework.stereotype.Repository;

import snippets.jee.entity.HousePhoto;
import snippets.jee.persistence.HousePhotoDAO;

@Repository
public class HousePhotoDAOImpl extends BaseDAOAdapter<HousePhoto, Integer> implements HousePhotoDAO {
}
