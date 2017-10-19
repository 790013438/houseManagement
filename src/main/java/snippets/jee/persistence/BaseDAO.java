package snippets.jee.persistence;

import java.io.Serializable;
import java.util.List;

import snippets.jee.entity.User;

public interface BaseDAO <E, K extends Serializable>{

    K save (E entity);

    void delete (E entity);

    boolean deleteById (K id);

    void update (E entity);

    E findById (K id);

    List<E> findAll();

    User findByUsername(String username);

}
