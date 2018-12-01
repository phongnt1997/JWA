/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conn;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author PhongNTSE1997
 */
public class Myconnection {
    public static Connection getMyConnection() throws Exception{
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433; databaseName = LoginDB;" + "user = sa; password = phong123");
        return conn;
    }
}
