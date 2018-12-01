/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phong.utils;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author PhongNTSE1997
 */
public class DButil implements Serializable{
    public static Connection makeConnection() throws SQLException, NamingException{
        Context context = new InitialContext();
        Context tom = (Context) context.lookup("java:comp/env");
        DataSource dt = (DataSource)tom.lookup("PHONGNT");
        Connection con = dt.getConnection();
        return con;
    }
}
