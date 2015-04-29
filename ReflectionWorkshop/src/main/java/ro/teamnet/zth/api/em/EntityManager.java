package ro.teamnet.zth.api.em;

import java.util.List;

/**
 * Created by Andrei on 04/29/2015.
 */
public interface EntityManager {
    public <T> T findById(Class<T> entityClass, int id);
    public <T> List<T> findAll(Class<T> entityClass);
    public <T> Object insert(T entity);
    public <T> T update(T entity);
    public void delete(Object entity);


}
