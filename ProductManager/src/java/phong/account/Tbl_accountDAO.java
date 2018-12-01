/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phong.account;

import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.naming.NamingException;
import phong.utils.DButil;

/**
 *
 * @author PhongNTSE1997
 */
public class Tbl_accountDAO implements Serializable{
    public Tbl_accountDTO checkLogin(String username, String password) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try{
            con = DButil.makeConnection();
            String sql = "Select * from tbl_account where accountID = ? and password = ? and (SELECT GETDATE()) < expired";
            stm = con.prepareStatement(sql);
            stm.setString(1, username);
            stm.setString(2, password);
            rs = stm.executeQuery();
            if(rs.next()) {
                String name = rs.getString("employeeName");
                String expired = rs.getString("expired");
                Tbl_accountDTO dto = new Tbl_accountDTO(username, password, name, expired);
                return dto;
            }
        }finally{
            if(rs != null) rs.close();
            if(stm != null) stm.close();
            if(con != null) con.close();
        }
        return null;    
    }
    
}
