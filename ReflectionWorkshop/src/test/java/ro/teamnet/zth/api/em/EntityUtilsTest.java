package ro.teamnet.zth.api.em;

import org.junit.Test;
import ro.teamnet.zth.api.annotations.Column;
import ro.teamnet.zth.api.annotations.Id;
import ro.teamnet.zth.api.annotations.Table;
import ro.teamnet.zth.appl.domain.Department;
import ro.teamnet.zth.appl.domain.Employee;
import ro.teamnet.zth.appl.domain.Job;
import ro.teamnet.zth.appl.domain.Location;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Andrei on 04/28/2015.
 */
public class EntityUtilsTest {

    @Test
    public void testGetTableNameMethod() {
        String tableNameDepartment = EntityUtils.getTableName(Department.class);
        String tableNameJobs = EntityUtils.getTableName(Job.class);
        String tableNameEmployees = EntityUtils.getTableName(Employee.class);
        String tableNameLocations = EntityUtils.getTableName(Location.class);
        assertEquals("Table name should be departments!", "departments", tableNameDepartment);
        assertEquals("Table name should be jobs!", "jobs", tableNameJobs);
        assertEquals("Table name should be employees", "employees", tableNameEmployees);
        assertEquals("Table name should be locations", "locations", tableNameLocations);
    }

    @Test
    public void testGetFieldsByAnnotationsMethod(){
        List<Field> fieldsByAnnotations = EntityUtils.getFieldsByAnnotations(Department.class, Id.class);
        for(Field f: fieldsByAnnotations){
            System.out.println(f.toString());
        }
        fieldsByAnnotations = EntityUtils.getFieldsByAnnotations(Job.class, Table.class);
        for(Field f: fieldsByAnnotations){
            System.out.println(f.toString());
        }

        fieldsByAnnotations = EntityUtils.getFieldsByAnnotations(Employee.class, Column.class);
        for(Field f: fieldsByAnnotations) {
            System.out.println(f.toString());
        }
    }

    @Test
    public void testGetColumnsMethod(){
        List<ColumnInfo> columns = EntityUtils.getColumns(Employee.class);
        for(ColumnInfo c: columns){
            System.out.println(c.toString());
        }
    }
}
