/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phong.user;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.NamingException;
import phong.utils.DButil;

/**
 *
 * @author PhongNTSE1997
 */
public class Tbl_UserDAO implements Serializable {

    public Tbl_UserDTO checkLogin(String userID, String password) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DButil.makeConnection();
            String sql = "Select * from tbl_User where userID = ? and password = ?";
            stm = con.prepareStatement(sql);
            stm.setString(1, userID);
            stm.setString(2, password);
            rs = stm.executeQuery();
            if(rs.next()) {
                String userid = rs.getString("userID");
                String pass = rs.getString("password");
                String fullname = rs.getString("fullName");
                int role = rs.getInt("role");
                Tbl_UserDTO dto = new Tbl_UserDTO(userid, password, fullname, role);
                return dto;
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return null;
    }
}
