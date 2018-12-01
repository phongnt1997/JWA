/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import dtos.DTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author PhongNTSE1997
 */
public class DAO {
    private Connection conn;
    private PreparedStatement pre;
    private ResultSet rs;
    
    private void closeConn() throws Exception {
        if(rs != null) rs.close();
        if(pre != null) rs.close();
        if(conn != null) conn.close();
    }
    
    public boolean insert(DTO dto) throws Exception {
        boolean check = false;
        return check;
    }
}
