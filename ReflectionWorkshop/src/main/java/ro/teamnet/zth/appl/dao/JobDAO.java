package ro.teamnet.zth.appl.dao;

import ro.teamnet.zth.api.database.DBManager;
import ro.teamnet.zth.api.em.EntityManagerImpl;
import ro.teamnet.zth.appl.domain.Department;
import ro.teamnet.zth.appl.domain.Job;

import java.sql.Connection;
import java.sql.Statement;
import java.util.List;

/**
 * Created by Andrei on 04/30/2015.
 */
public class JobDAO {
    Connection connection = DBManager.getConnection();
    EntityManagerImpl entityManager = new EntityManagerImpl();
    Statement instr;

    public JobDAO() {
    }

    public void insertJob(Job job) {

        entityManager.insert(job);
    }

    public void updateJob(Job job) {
        entityManager.update(job);
    }

    public void deleteJob(Job job) {

        entityManager.delete(job);
    }

    public List<Job> findAllJobs() {

        return entityManager.findAll(Job.class);
    }

    public Job findJobById(int id) {

        return entityManager.findById(Job.class, id);
    }
}
