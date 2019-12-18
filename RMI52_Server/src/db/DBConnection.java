/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.Connection;
import java.sql.SQLException;
import org.apache.commons.dbcp2.BasicDataSource;

/**
 *
 * @author sanu
 */
public class DBConnection {

    private static DBConnection dbConnection;
    private BasicDataSource bds;

    private DBConnection() throws ClassNotFoundException, SQLException {
        bds= new BasicDataSource();
        bds.setDriverClassName("com.mysql.jdbc.Driver");
        bds.setUrl("jdbc:mysql://localhost:3306/Thogakade");
        bds.setUsername("root");
        bds.setPassword("nuwanjith");
        bds.setInitialSize(2);
        bds.setMaxTotal(2);
    }

    public static DBConnection getInstance() throws ClassNotFoundException, SQLException {
        return (dbConnection == null) ? (dbConnection = new DBConnection()) : dbConnection;
    }

    public Connection getConnection() throws SQLException {
        return bds.getConnection();
    }
}
