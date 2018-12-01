/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phong.struts;

import phong.mobile.Tbl_MobileDAO;

/**
 *
 * @author PhongNTSE1997
 */
public class UpdateMobileAction {
    private String mobileID;
    private String lastSearchValue;
    private String price;
    private String description;
    private String quantity;
    private boolean notSale;
    
    private final String Success = "success";
    private final String fail = "fail";
    public UpdateMobileAction() {
    }

    public String getMobileID() {
        return mobileID;
    }

    public void setMobileID(String mobileID) {
        this.mobileID = mobileID;
    }

    public String getLastSearchValue() {
        return lastSearchValue;
    }

    public void setLastSearchValue(String lastSearchValue) {
        this.lastSearchValue = lastSearchValue;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public boolean isNotSale() {
        return notSale;
    }

    public void setNotSale(boolean notSale) {
        this.notSale = notSale;
    }
    
    public String execute() throws Exception {
        Tbl_MobileDAO dao = new Tbl_MobileDAO();
        dao.updateMobile(mobileID, price, description, quantity, notSale);
        return Success;
    }
    
}
