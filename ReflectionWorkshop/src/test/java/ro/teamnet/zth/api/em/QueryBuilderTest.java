package ro.teamnet.zth.api.em;

/**
 * Created by Andrei on 04/28/2015.
 */

import org.junit.Test;
import ro.teamnet.zth.api.annotations.Column;
import ro.teamnet.zth.appl.domain.Department;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class QueryBuilderTest {

    @Test
    public void testQueryBuilderSelect() {
        QueryBuilder builder = new QueryBuilder();
        List<Condition> conditions = new ArrayList<Condition>();
        Condition c = new Condition();
        c.setColumnName("job_id");
        c.setValue("1");
        Condition c2 = new Condition();
        c2.setColumnName("min_salary");
        c2.setValue(200);
        conditions.add(c);
        conditions.add(c2);
        List<ColumnInfo> columns = new ArrayList<ColumnInfo>();
        ColumnInfo cInfo = new ColumnInfo();
        cInfo.setDbName("job_title");
        ColumnInfo cInfo2 = new ColumnInfo();
        cInfo2.setDbName("min_salary");
        columns.add(cInfo);
        columns.add(cInfo2);
        Object title = new String("jobs");
        System.out.println(builder.createSelectQuery(title, null, conditions));
        System.out.println();
        System.out.println(builder.createSelectQuery(title, columns, null));
        System.out.println();
        System.out.println(builder.createSelectQuery(title, null, null));
        System.out.println();
    }

    @Test
    public void testQueryBuilderInsert() {
        QueryBuilder builder = new QueryBuilder();
        List<Condition> conditions = new ArrayList<Condition>();
        Condition c = new Condition();
        c.setColumnName("job_id");
        c.setValue("1");
        Condition c2 = new Condition();
        c2.setColumnName("min_salary");
        c2.setValue(200);
        conditions.add(c);
        conditions.add(c2);
        List<ColumnInfo> columns = new ArrayList<ColumnInfo>();
        ColumnInfo cInfo = new ColumnInfo();
        cInfo.setDbName("job_title");
        ColumnInfo cInfo2 = new ColumnInfo();
        cInfo2.setDbName("min_salary");
        columns.add(cInfo);
        columns.add(cInfo2);
        Object title = new String("jobs");
        System.out.println(builder.createInsertQuery(title, columns, conditions));
        System.out.println();
    }

    @Test
    public void testQueryBuilderDelete() {
        QueryBuilder builder = new QueryBuilder();
        List<Condition> conditions = new ArrayList<Condition>();
        Condition c = new Condition();
        c.setColumnName("job_id");
        c.setValue("1");
        Condition c2 = new Condition();
        c2.setColumnName("min_salary");
        c2.setValue(200);
        conditions.add(c);
        conditions.add(c2);
        List<ColumnInfo> columns = new ArrayList<ColumnInfo>();
        ColumnInfo cInfo = new ColumnInfo();
        cInfo.setDbName("job_title");
        ColumnInfo cInfo2 = new ColumnInfo();
        cInfo2.setDbName("min_salary");
        columns.add(cInfo);
        columns.add(cInfo2);
        Object title = new String("jobs");
        System.out.println(builder.createDeleteQuery(title, conditions));
        System.out.println();
    }

    @Test
    public void testQueryBuilderUpdate() {
        QueryBuilder builder = new QueryBuilder();
        List<Condition> conditions = new ArrayList<Condition>();
        Condition c = new Condition();
        c.setColumnName("job_id");
        c.setValue("1");
        Condition c2 = new Condition();
        c2.setColumnName("min_salary");
        c2.setValue(200);
        conditions.add(c);
        conditions.add(c2);
        List<ColumnInfo> columns = new ArrayList<ColumnInfo>();
        ColumnInfo cInfo = new ColumnInfo();
        cInfo.setDbName("job_title");
        cInfo.setValue("President");
        ColumnInfo cInfo2 = new ColumnInfo();
        cInfo2.setDbName("min_salary");
        cInfo2.setValue("300");
        columns.add(cInfo);
        columns.add(cInfo2);
        Object title = new String("jobs");
        System.out.println(builder.createUpdateQuery(title, columns, conditions));
        System.out.println();
    }

}