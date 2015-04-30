package ro.teamnet.zth.appl.dao;

import ro.teamnet.zth.api.database.DBManager;
import ro.teamnet.zth.api.em.EntityManagerImpl;
import ro.teamnet.zth.appl.domain.Department;
import ro.teamnet.zth.appl.domain.Location;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 * Created by Andrei on 04/30/2015.
 */
public class LocationDAO {
    Connection connection = DBManager.getConnection();
    EntityManagerImpl entityManager = new EntityManagerImpl();
    Statement instr;

    public LocationDAO(){
    }

    public void insertLocation(Location location){
        entityManager.insert(location);
    }

    public void updateLocation(Location location){
        entityManager.update(location);
    }

    public void deleteLocation(Location location){
        entityManager.delete(location);
    }

    public List<Location> findAllLocations(){
        return entityManager.findAll(Location.class);
    }

    public Location findLocationById(int id){
        return entityManager.findById(Location.class,id);
    }
}
