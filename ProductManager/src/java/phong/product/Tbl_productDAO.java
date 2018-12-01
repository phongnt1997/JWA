/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phong.product;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import phong.account.Tbl_accountDTO;
import phong.utils.DButil;

/**
 *
 * @author PhongNTSE1997
 */
public class Tbl_productDAO implements Serializable{
    List<Tbl_productDTO> items;

    public  List<Tbl_productDTO> getItems() {
        return items;
    }
    
    public void makeListItems() throws SQLException, NamingException{
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DButil.makeConnection();
            String sql = "Select * from tbl_product";
            stm = con.prepareStatement(sql);
            rs = stm.executeQuery();
            while(rs.next()) {
                String productID = rs.getString("productID");
                String productName = rs.getString("productName");
                String price = rs.getString("price");
                String quantity = rs.getString("quantity");
                String unit = rs.getString("unit");
                Tbl_productDTO dto = new Tbl_productDTO(productID, productName, price, quantity, unit);
                if(this.items == null) {
                    this.items = new ArrayList<>();
                }
                this.items.add(dto);
            }
        } finally {
            if(rs != null) rs.close();
            if(stm != null) stm.close();
            if(con != null) con.close();
        }
    }
    
    public boolean insertProduct(String id, String name, String unit) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        try {
            con = DButil.makeConnection();
            String sql = "Insert into tbl_product (productID, productName, unit, quantity) values (?,?,?,0)";
            stm = con.prepareStatement(sql);
           stm.setString(1, id);
           stm.setString(2, name);
           stm.setString(3, unit);
           int result = stm.executeUpdate();
           if(result > 0) return true;
        } finally {
            if(stm != null) stm.close();
            if(con != null) con.close();
        }
        return false;
    }
    
    public boolean updateProduct(String pk, String price, String unit) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        try {
            con = DButil.makeConnection();
            String sql = "Update tbl_product set price = ?, unit = ? where productID = ?";
            stm = con.prepareStatement(sql);
           stm.setString(1, price);
           stm.setString(2, unit);
           stm.setString(3, pk);
           int result = stm.executeUpdate();
           if(result > 0) return true;
        } finally {
            if(stm != null) stm.close();
            if(con != null) con.close();
        }
        return false;
    }
    
    public boolean deleteProduct(String pk) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        try {
            con = DButil.makeConnection();
            String sql = "Delete from tbl_product where productID = ?";
            stm = con.prepareStatement(sql);
           stm.setString(1, pk);
           int result = stm.executeUpdate();
           if(result > 0) return true;
        } finally {
            if(stm != null) stm.close();
            if(con != null) con.close();
        }
        return false;
    }
    public boolean importProduct(String id, String name, String price, String quantity) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        try {
            con = DButil.makeConnection();
            String sql = "insert into tbl_import (importedDate, price, productID, quantity)" +
                                "values((Select GETDATE()), ?, ?, ?)" +
                            "Update tbl_product set quantity = "
                            + "(select quantity from tbl_product where productID = ?) + ? "
                    + "where productID = ?";
            stm = con.prepareStatement(sql);
           stm.setString(1, price);
           stm.setString(2, id);
           stm.setString(3, quantity);
           stm.setString(4, id);
           stm.setString(5, quantity);
           stm.setString(6, id);
           int result = stm.executeUpdate();
           if(result > 0) return true;
        } finally {
            if(stm != null) stm.close();
            if(con != null) con.close();
        }
        return false;
    }
}
