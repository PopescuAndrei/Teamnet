package ro.teamnet.zth.api.database;

import org.junit.Test;
import ro.teamnet.zth.api.em.EntityUtils;
import ro.teamnet.zth.appl.domain.Department;

import java.sql.Connection;

import static org.junit.Assert.*;

/**
 * Created by Andrei on 04/28/2015.
 */
public class DatabaseTest {
    @Test
    public void testDBConnection() {
        Connection db = DBManager.getConnection();
        System.out.println(DBManager.checkConnection(db));
        assertNotNull("DB connection ", DBManager.checkConnection(db));
    }
}
