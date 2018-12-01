package phong.login;


import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import phong.utils.DBUtils;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author PhongNTSE1997
 */
public class LoginDAO implements Serializable{
    public boolean checkLogin(String username, String password) throws SQLException, NamingException{
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBUtils.makeConnection();
            String sql = "Select * from LoginTB where username = ? and password = ?";
            stm = con.prepareStatement(sql);
            stm.setString(1, username);
            stm.setString(2, password);
            rs = stm.executeQuery();
            if(rs.next()) {
                return true;
            }
        }finally {
            if(rs != null) rs.close();
            if(stm != null) stm.close();
            if(stm != null) con.close();
        }
        return false;
    }
    
    private List<LoginDTO> listAcc;

    public List<LoginDTO> getListAcc() {
        return listAcc;
    }
    

    
    public void searchValue(String searchVaue) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBUtils.makeConnection();
            String sql = "Select * from LoginTB where fullname like ?";
            stm = con.prepareStatement(sql);
            stm.setString(1, "%" + searchVaue + "%");
           
            rs = stm.executeQuery();
            while(rs.next()) {
                String user = rs.getString("username");
                String password = rs.getString("password");
                String fullname = rs.getString("fullname");
                String role = rs.getString("role");
                LoginDTO dto = new LoginDTO(fullname, password, fullname, role);
                if(listAcc == null) {
                    listAcc = new ArrayList<>();
                }
                listAcc.add(dto);
            }
                
        }finally {
            if(rs != null) rs.close();
            if(stm != null) stm.close();
            if(stm != null) con.close();
        }
        
    }
    }

