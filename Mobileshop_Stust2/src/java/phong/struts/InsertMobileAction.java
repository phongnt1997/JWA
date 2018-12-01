/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phong.struts;

import com.opensymphony.xwork2.ActionContext;
import java.util.Map;
import phong.mobile.Tbl_MobileDAO;

/**
 *
 * @author PhongNTSE1997
 */
public class InsertMobileAction {
    private String mobileID;
    private String mobileName;
    private String description;
    private String price;
    private String yom;
    private String quantity;
    private String MSG;
    private final String SUCCESS = "success";
    public String getMobileID() {
        return mobileID;
    }

    public String getMSG() {
        return MSG;
    }

    public void setMSG(String MSG) {
        this.MSG = MSG;
    }
    
    public void setMobileID(String mobileID) {
        this.mobileID = mobileID;
    }

    public String getMobileName() {
        return mobileName;
    }

    public void setMobileName(String mobileName) {
        this.mobileName = mobileName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getYom() {
        return yom;
    }

    public void setYom(String yom) {
        this.yom = yom;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }
    
    public InsertMobileAction() {
    }
    
    public String execute() throws Exception {
        Tbl_MobileDAO dao = new Tbl_MobileDAO();
        boolean result = dao.insertMobile(mobileID, mobileName, price, description, yom, quantity);
        if(result) {
            MSG = "Insert success";
        }
        else{
            MSG = "Can not insert this mobile"; 
        }
        return SUCCESS;
    }
    
}
