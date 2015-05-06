package ro.teamnet.zth.appl.dao;

import ro.teamnet.zth.api.database.DBManager;
import ro.teamnet.zth.api.em.EntityManagerImpl;
import ro.teamnet.zth.appl.domain.Employee;

import java.sql.Connection;
import java.sql.Statement;
import java.util.List;

/**
 * Created by Andrei on 04/30/2015.
 */
public class EmployeeDAO {
    Connection connection = DBManager.getConnection();
    EntityManagerImpl entityManager = new EntityManagerImpl();
    Statement instr;

    public EmployeeDAO() {
    }

    public void insertEmployee(Employee employee) {

        entityManager.insert(employee);
    }

    public void updateEmployee(Employee employee) {
        entityManager.update(employee);
    }

    public void deleteEmployee(Employee employee) {

        entityManager.delete(employee);
    }

    public List<Employee> findAllEmployees() {

        return entityManager.findAll(Employee.class);
    }

    public Employee findEmployeeById(int id) {

        return entityManager.findById(Employee.class, id);
    }
}
