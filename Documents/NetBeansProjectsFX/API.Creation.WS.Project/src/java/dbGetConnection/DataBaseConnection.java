/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbGetConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Aya
 */
public class DataBaseConnection {
    
    public static final String URL = "jdbc:mysql://localhost:3306/medical_insurance_database";
    public static final String USERNAME = "root";
    public static final String PASSWORD = "";
    private static Connection connection;

    private DataBaseConnection(Connection connection) {
        this.connection=connection;
    }
    
    
    public static Connection getConnection() {
//        if(connection != null)
//        {   
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException ex) {
            Logger.getLogger(DataBaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DataBaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
      //  }
        return connection;
    }
    
    
    
}
