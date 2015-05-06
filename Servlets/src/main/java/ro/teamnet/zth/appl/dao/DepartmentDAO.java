package ro.teamnet.zth.appl.dao;

import ro.teamnet.zth.api.database.DBManager;
import ro.teamnet.zth.api.em.EntityManagerImpl;
import ro.teamnet.zth.appl.domain.Department;

import java.sql.Connection;
import java.sql.Statement;
import java.util.List;

/**
 * Created by Andrei on 04/30/2015.
 */
public class DepartmentDAO {
    Connection connection = DBManager.getConnection();
    EntityManagerImpl entityManager = new EntityManagerImpl();
    Statement instr;

    public DepartmentDAO() {
    }

    public Department insertDepartment(Department department) {

        return entityManager.insert(department);
    }

    public void updateDepartment(Department department) {
        entityManager.update(department);
    }

    public void deleteDepartment(Department department) {

        entityManager.delete(department);
    }

    public List<Department> findAllDepartments() {

        return entityManager.findAll(Department.class);
    }

    public Department findDepartmentById(int id) {

        return entityManager.findById(Department.class, id);
    }
}
