/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phong.mobile;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.naming.NamingException;
import phong.cart.CartObj;
import phong.utils.DButil;

/**
 *
 * @author PhongNTSE1997
 */
public class Tbl_MobileDAO implements Serializable {

    private List<Tbl_MobileDTO> listMobile;

    public List<Tbl_MobileDTO> getListMobile() {
        return listMobile;
    }

    public void searchByIDOrName(String searchValue) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DButil.makeConnection();
            String sql = "Select * from tbl_Mobile where mobileID like ? or mobileName like ?";
            stm = con.prepareStatement(sql);
            stm.setString(1, "%" + searchValue + "%");
            stm.setString(2, "%" + searchValue + "%");
            rs = stm.executeQuery();
            while (rs.next()) {
                String mobileID = rs.getString("mobileID");
                String mobileName = rs.getString("mobileName");
                String description = rs.getString("description");
                String price = rs.getString("price");
                String yom = rs.getString("yearOfProduction");
                boolean notSale = rs.getInt("notSale") == 1;
                String quantity = rs.getString("quantity");
                Tbl_MobileDTO dto = new Tbl_MobileDTO(mobileID, mobileName, description, price, yom, notSale, quantity);
                if (this.listMobile == null) {
                    this.listMobile = new ArrayList<>();
                }
                this.listMobile.add(dto);
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
    }

    public boolean deleteMobile(String pk) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        try {
            con = DButil.makeConnection();
            String sql = "Delete from tbl_Mobile where mobileID = ?";
            stm = con.prepareStatement(sql);
            stm.setString(1, pk);
            int result = stm.executeUpdate();
            if (result > 0) {
                return true;
            }
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return false;
    }

    public boolean updateMobile(String pk, String price, String decreption, String quantity, boolean noSale)
            throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        try {
            con = DButil.makeConnection();
            String sql = "Update tbl_Mobile set description = ?, price = ?, quantity = ?, notSale = ? where mobileID = ?";
            stm = con.prepareStatement(sql);
            stm.setString(1, decreption);
            stm.setString(2, price);
            stm.setString(3, quantity);
            stm.setString(4, Integer.toString(noSale ? 1 : 0));
            stm.setString(5, pk);
            int result = stm.executeUpdate();
            if (result > 0) {
                return true;
            }
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return false;
    }

    public boolean insertMobile(String id, String name, String price, String description, String yom,
            String quantity) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        try {
            con = DButil.makeConnection();
            String sql = "Insert into tbl_Mobile (mobileID, description, price, mobileName, yearOfProduction, quantity, notSale)"
                    + "values(?,?,?,?,?,?,?)";
            stm = con.prepareStatement(sql);
            stm.setString(1, id);
            stm.setString(2, description);
            stm.setString(3, price);
            stm.setString(4, name);
            stm.setString(5, yom);
            stm.setString(6, quantity);
            stm.setString(7, "1");
            int result = stm.executeUpdate();
            if (result > 0) {
                return true;
            }
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return false;
    }

    public void searchByPrice(String min, String max) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        if ("".equals(min)) {
            min = getMinPrice();
        } else if ("".equals(max)) {
            max = getMaxPrice();
        }
        try {
            con = DButil.makeConnection();
            String sql = "select * from tbl_Mobile where price >= ? and price <= ?";
            stm = con.prepareStatement(sql);
            try {
                stm.setFloat(1, Float.parseFloat(min));
                stm.setFloat(2, Float.parseFloat(max));
            } catch (Exception e) {
                return;
            }

            rs = stm.executeQuery();
            while (rs.next()) {
                String mobileID = rs.getString("mobileID");
                String mobileName = rs.getString("mobileName");
                String description = rs.getString("description");
                String price = rs.getString("price");
                String yom = rs.getString("yearOfProduction");
                boolean notSale = rs.getInt("notSale") == 1;
                String quantity = rs.getString("quantity");
                Tbl_MobileDTO dto = new Tbl_MobileDTO(mobileID, mobileName, description, price, yom, notSale, quantity);
                if (this.listMobile == null) {
                    this.listMobile = new ArrayList<>();
                }
                this.listMobile.add(dto);
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
    }

    public String getMinPrice() throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {

            con = DButil.makeConnection();
            String sql = "select min(price) as minPrice from tbl_Mobile";
            stm = con.prepareStatement(sql);
            rs = stm.executeQuery();
            if (rs.next()) {
                return rs.getString("minPrice");
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
        return "";
    }

    public String getMaxPrice() throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {

            con = DButil.makeConnection();
            String sql = "select max(price) as maxPrice from tbl_Mobile";
            stm = con.prepareStatement(sql);
            rs = stm.executeQuery();
            if (rs.next()) {
                return rs.getString("maxPrice");
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
        return "";
    }

    public boolean checkOut(CartObj cart) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            String customerID = cart.getCustomerID();
            float total = cart.getTotal();
            con = DButil.makeConnection();
            String sqlOrder = "insert into tbl_Order(userID, total) values (?,?)";
            stm = con.prepareStatement(sqlOrder);
            stm.setString(1, customerID);
            stm.setString(2, Float.toString(total));
            int orderResult = stm.executeUpdate();
            if (orderResult > 0) {
                String sqlDetail = "insert into tbl_OrderDetail(orderID, mobileID, quantity) values((select max(orderID) from tbl_Order) ,?,?)";
                String sqlUpdate = "update tbl_Mobile set quantity = "
                        + "((Select quantity from tbl_Mobile where mobileID = 'GLX1')) - ? "
                        + "where mobileID = ?";

                Map<String, Tbl_MobileDTO> items = cart.getItems();
                Set<String> ids = items.keySet();
                int result = 0;
                for (String mobileID : ids) {
                    stm = con.prepareStatement(sqlDetail);
                    Tbl_MobileDTO dto = items.get(mobileID);
                    String quantity = dto.getQuantity();

                    stm.setString(1, mobileID);
                    stm.setString(2, quantity);
                    result = stm.executeUpdate();
                    if (result == 0) {
                        return false;
                    } else {
                        stm = con.prepareStatement(sqlUpdate);
                        stm.setString(1, quantity);
                        stm.setString(2, mobileID);
                    }

                }
                if (result > 0) {
                    return true;
                }
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
        return false;
    }
}
