package data;

import entities.models.SystemException;
import utils.EnvProperties;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseHelper {
    public static Connection getConnection() throws SystemException {
        String url = EnvProperties.getValue("DATABASE_URL");
        String user = EnvProperties.getValue("USER");;
        String password = EnvProperties.getValue("PASSWORD");;
        String driver = EnvProperties.getValue("DRIVER_URL");;
        try {
            Class.forName(driver);
            Connection connection = DriverManager.getConnection(url, user, password);
            return connection;
        }catch(SQLException e){
            throw new SystemException("connection_failure");
        }catch(ClassNotFoundException e){
            throw new SystemException("connection_failure");
        }
    }
}
