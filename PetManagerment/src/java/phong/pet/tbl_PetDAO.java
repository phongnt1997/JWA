/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phong.pet;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import phong.utils.DBUtil;

/**
 *
 * @author PhongNTSE1997
 */
public class tbl_PetDAO implements Serializable{
    private List<tbl_PetDTO> listPet;

    public List<tbl_PetDTO> getListPet() {
        return listPet;
    }
    public void searchPetbyName(String searchValue) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBUtil.makeConnection();
            if(con != null) {
                String sql = "Select * from tbl_Pet where petName like ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, "%"+searchValue+"%");
                rs = stm.executeQuery();//query search ra ket qua
                while(rs.next()) {
                    String petID = rs.getString("petID");
                    String petName = rs.getString("petName");
                    String description = rs.getString("description");
                    Timestamp dob = rs.getTimestamp("dob");
                    String vaccineDesp = rs.getString("vaccineDesp");
                    float price = rs.getFloat("price");
                    tbl_PetDTO dto = new tbl_PetDTO(petID, petName, description, dob, vaccineDesp, price);
                    if(this.listPet == null) {
                        this.listPet = new ArrayList<>();
                    }
                    this.listPet.add(dto);
                }
            }
        } finally {
            if(rs != null) rs.close();
            if(stm != null) stm.close();
            if(con != null) stm.close();
        }
    }
    
}
