package ro.teamnet.zth.api.em;

import ro.teamnet.zth.api.annotations.Id;
import ro.teamnet.zth.api.database.DBManager;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andrei on 04/29/2015.
 */
public class EntityManagerImpl implements EntityManager {

    @Override
    public <T> T findById(Class<T> entityClass, int id) {
        Connection conn = DBManager.getConnection();
        T result = null;
        String tableName = EntityUtils.getTableName(entityClass);
        List<ColumnInfo> columns = EntityUtils.getColumns(entityClass);
        Condition condition = new Condition();
        condition.setColumnName(EntityUtils.getFieldsByAnnotations(entityClass, Id.class).get(0).getAnnotation(Id.class).name());
        condition.setValue(id);
        List<Condition> conditions = new ArrayList<>();
        conditions.add(condition);
        QueryBuilder queryBuilder = new QueryBuilder();
        try (Statement st = conn.createStatement()) {
            ResultSet rs = st.executeQuery(queryBuilder.createQuery(QueryType.SELECT, tableName, null, conditions));
            while (rs.next()) {
                result = entityClass.newInstance();
                for (ColumnInfo c : columns) {
                    Field f = result.getClass().getDeclaredField(c.getColumnName());
                    f.setAccessible(true);
                    f.set(result, rs.getObject(c.getDbName()));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public <T> List<T> findAll(Class<T> entityClass) {
        Connection conn = DBManager.getConnection();
        List<T> resultList = null;
        T result = null;
        String tableName = EntityUtils.getTableName(entityClass);
        List<ColumnInfo> columns = EntityUtils.getColumns(entityClass);
        QueryBuilder queryBuilder = new QueryBuilder();
        try (Statement st = conn.createStatement()) {
            ResultSet rs = st.executeQuery(queryBuilder.createQuery(QueryType.SELECT, tableName, null, null));
            resultList = new ArrayList<T>();
            while (rs.next()) {
                result = entityClass.newInstance();
                for (ColumnInfo c : columns) {
                    Field f = result.getClass().getDeclaredField(c.getColumnName());
                    f.setAccessible(true);
                    f.set(result, rs.getObject(c.getDbName()));
                }
                resultList.add(result);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        return resultList;
    }

    @Override
    public <T> T insert(T entity) {
        Connection conn = DBManager.getConnection();
        T result = null;
        int id = -1;
        String tableName = EntityUtils.getTableName(entity.getClass());
        List<ColumnInfo> columns = EntityUtils.getColumns(entity.getClass());
        List<Condition> conditions = new ArrayList<Condition>();
        Field f = null;

        try {
            for (ColumnInfo column : columns) {
                f = entity.getClass().getDeclaredField(column.getColumnName());
                f.setAccessible(true);
                column.setValue(f.get(entity));
                Condition c = new Condition();
                c.setColumnName(column.getDbName());
                c.setValue(column.getValue());
                conditions.add(c);
            }
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        QueryBuilder queryBuilder = new QueryBuilder();
        try (Statement st = conn.createStatement()) {
            st.execute(queryBuilder.createQuery(QueryType.INSERT, tableName, columns, conditions));
            ResultSet rs = st.executeQuery("SELECT LAST_INSERT_ID()");
            rs.next();
            id = rs.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return (T) findById(entity.getClass(), id);
    }


    @Override
    public <T> T update(T entity) {
        Connection conn = DBManager.getConnection();
        T result = null;
        String tableName = EntityUtils.getTableName(entity.getClass());
        List<ColumnInfo> columns = EntityUtils.getColumns(entity.getClass());
        List<Condition> conditions = new ArrayList<Condition>();
        Field f = null;
        try {
            for (ColumnInfo column : columns) {
                f = entity.getClass().getDeclaredField(column.getColumnName());
                f.setAccessible(true);
                column.setValue(f.get(entity));
                Condition c = new Condition();
                c.setColumnName(column.getDbName());
                c.setValue(column.getValue());
                conditions.add(c);
            }
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        QueryBuilder queryBuilder = new QueryBuilder();
        try (Statement st = conn.createStatement()) {
            st.execute(queryBuilder.createQuery(QueryType.UPDATE, tableName, columns, conditions));

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }


    @Override
    public void delete(Object entity) {
        Connection conn = DBManager.getConnection();
        String tableName = EntityUtils.getTableName(entity.getClass());
        List<ColumnInfo> columns = EntityUtils.getColumns(entity.getClass());

        Field f = null;

        try {
            for (ColumnInfo column : columns) {
                f = entity.getClass().getDeclaredField(column.getColumnName());
                f.setAccessible(true);
                column.setValue(f.get(entity));
            }
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        Condition condition = new Condition();
        condition.setColumnName(columns.get(0).getDbName());
        condition.setValue(columns.get(0).getValue());
        List<Condition> conditions = new ArrayList<>();
        conditions.add(condition);
        QueryBuilder queryBuilder = new QueryBuilder();
        try (Statement st = conn.createStatement()) {
            st.executeUpdate(queryBuilder.createQuery(QueryType.DELETE, tableName, null, conditions));

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
