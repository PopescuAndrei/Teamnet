package ro.teamnet.zth.api.em;

import org.junit.Test;
import ro.teamnet.zth.api.annotations.Id;
import ro.teamnet.zth.appl.domain.Department;
import ro.teamnet.zth.appl.domain.Location;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andrei on 04/29/2015.
 */
public class EntityManagerImplTest {

    @Test
    public void testFindByIdQuery(){
        EntityManagerImpl entityManager = new EntityManagerImpl();
        System.out.println(entityManager.findById(Location.class,1100).toString());
    }

    @Test
    public void testFindAll(){
        EntityManagerImpl entityManager = new EntityManagerImpl();
        System.out.println(entityManager.findAll(Location.class).toString());
    }

    @Test
    public void testInsert(){
        EntityManagerImpl entityManager = new EntityManagerImpl();
        Location location = new Location();
        location.setAddress("Address");
        location.setCity("City");
        location.setId(1);
        location.setPostalCode("115100");
        location.setStateProvince("Province");
        entityManager.insert(location);
    }

    @Test
    public void testUpdate(){
        EntityManagerImpl entityManager = new EntityManagerImpl();
        Location location = entityManager.findById(Location.class,1);
        location.setAddress("Address2");
        entityManager.update(location);
    }
    @Test
    public void testDelete(){
        EntityManagerImpl entityManager = new EntityManagerImpl();
        Location location = entityManager.findById(Location.class, 1200);
        entityManager.delete(location);
        System.out.println(entityManager.findAll(Location.class).toString());
    }


    @Test
    public void testQuery(){
        QueryBuilder queryBuilder = new QueryBuilder();
        String tableName = EntityUtils.getTableName(Location.class);
        Condition condition = new Condition();
        condition.setValue(1200);
        List<Condition> conditions = new ArrayList<>();
        conditions.add(condition);
        System.out.println(queryBuilder.createQuery(QueryType.SELECT, tableName, null, conditions));
    }
}
