package ro.teamnet.zth.api.database;

import java.sql.*;

/**
 * Created by Andrei on 04/28/2015.
 */
public class DBManager {
    public static final String CONNECTION_STRING = "jdbc:mysql://" + DBProperties.IP + ":" + DBProperties.PORT + "/" + DBProperties.SCHEMA;

    private DBManager() {
        throw new UnsupportedOperationException();
    }

    private static void registerDriver() {
        try {
            Class.forName(DBProperties.DRIVER_CLASS);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        registerDriver();
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(CONNECTION_STRING, DBProperties.USER, DBProperties.PASS);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static boolean checkConnection(Connection connection) {
        Statement instr = null;
        boolean answer = false;
        try {
            instr = connection.createStatement();
            String sql = "SELECT 1 FROM DUAL";
            ResultSet rs = instr.executeQuery(sql);
            if (rs != null) {
                answer = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return answer;
    }
}
