/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sample.registration;


import Sample.utils.DBUtil;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.naming.NamingException;

/**
 *
 * @author PhongNTSE1997
 */
public class RegistrationDAO implements Serializable {

    public boolean checkLogin(String username, String password)
            throws NamingException, SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBUtil.makeConnection();
            if(con != null) {
                String sql = "SELECT * FROM LoginTB WHERE Username = ? AND Password = ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, username);
                stm.setString(2, password);
                rs = stm.executeQuery();
                
                
                
                if(rs.next()) {
                    
                    String fullname= rs.getString("Fullname");
                    String role = rs.getString("Role");
                    RegistrationDTO dto = new RegistrationDTO(username, password, fullname, role);
                    
                    return true;
                }
            }
            

        } finally {
            if(rs != null) {
                stm.close();
            }
            if(stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }

        return false;
    }
    private List<RegistrationDTO> listAcc;

    public List<RegistrationDTO> getListAcc() {
        return listAcc;
    }
    
    public void searchLastName(String searchValue) throws NamingException, SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBUtil.makeConnection();
            if(con != null) {
                String sql = "SELECT * FROM LoginTB WHERE Fullname like ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, "%" + searchValue + "%");
               
                rs = stm.executeQuery();
                while(rs.next()) {
                    String username = rs.getString("Username");
                    String password = rs.getString("Password");
                    String lastname = rs.getString("Fullname");
                    String role = rs.getString("Role");
                    
                    RegistrationDTO dto = new RegistrationDTO(username, password, lastname, role);
                    if(this.listAcc == null) {
                        this.listAcc = new ArrayList<>();
                    }
                    this.listAcc.add(dto);
                }
            }
            

        } finally {
            if(rs != null) {
                stm.close();
            }
            if(stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }

        
    }
    
    public boolean deleteAccount(String username) throws NamingException, SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        
        try {
            con = DBUtil.makeConnection();
            if(con != null) {
                String sql = "Delete from LoginTB where Username = ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, username);
                String test = sql;
                int row = stm.executeUpdate();
                if(row>0) {
                    return true;
                }
            }
            

        } finally {
            
            if(stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }

        return false;
    }
    
    public boolean updatePassRole(String username, String password, String role) throws NamingException, SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        
        try {
            con = DBUtil.makeConnection();
            if(con != null) {
                String sql = "Update LoginTB Set Password =?, Role = ? where Username =?";
                System.out.println(username);
                stm = con.prepareStatement(sql);
                stm.setString(1, password);
                stm.setString(2, role);
                stm.setString(3, username);
                int row = stm.executeUpdate();
                if(row>0) {
                    return true;
                }
            }
            

        } finally {
            
            if(stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }

        return false;
    }
    public boolean createAccount(String username, String password, String fullname, String role) throws NamingException, SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        
        try {
            con = DBUtil.makeConnection();
            if(con != null) {
                String sql = "Insert into LoginTB (Username, Password, Fullname, Role) Values (?, ?, ?, ?)";
                stm = con.prepareStatement(sql);
                stm.setString(1, username);
                stm.setString(2, password);
                stm.setString(3, fullname);
                stm.setString(4, role);
                int row = stm.executeUpdate();
                if(row>0) {
                    return true;
                }
            }
            

        } finally {
            
            if(stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }

        return false;
    }
    
//    public boolean checkOut(String fullname, String phone, CartObj cart) throws NamingException, SQLException {
//        Connection con = null;
//        PreparedStatement stmOrder = null;
//        PreparedStatement stmOrderDetail = null;
//        
//        try {
//            con = DBUtil.makeConnection();
//            if(con != null) {
//                String sqlOrder = "Insert into orderTB (Fullname,Phone) values (?, ?)";
//                stmOrder = con.prepareStatement(sqlOrder);
//                stmOrder.setString(1, fullname);
//                stmOrder.setString(2, phone);
//                    int rowOrder = stmOrder.executeUpdate();
//                    int rowOrderDetail = 0;
//                if(rowOrder > 0) {
//                String sqlOrderDetail = "Insert into orderDetailTB (Title,Quantity,Phone) values (?, ?, ?)";
//                Map<String, Integer> items = cart.getItems();
//                
//                if(items != null) {
//                    for(Map.Entry<String, Integer> item : items.entrySet()) {
//                        stmOrderDetail = con.prepareStatement(sqlOrderDetail);
//                        stmOrderDetail.setString(1, item.getKey());
//                        stmOrderDetail.setString(2, Integer.toString(item.getValue()));
//                        stmOrderDetail.setString(3, phone);
//                        rowOrderDetail = stmOrderDetail.executeUpdate(); 
//                        if(rowOrderDetail == 0) return false;
//                    }
//                }
//            }
//            if(rowOrder > 0 && rowOrderDetail > 0) return true;
//
//        }
//        } finally {
//            
//            if(stmOrder != null) {
//                stmOrder.close();
//            }
//            if(stmOrderDetail != null) {
//                stmOrderDetail.close();
//            }
//            if (con != null) {
//                con.close();
//            }
//        }
//
//        return false;
//    }
}
