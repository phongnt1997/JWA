/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phong.mobile;

import java.io.Serializable;

/**
 *
 * @author PhongNTSE1997
 */
public class Tbl_MobileDTO implements Serializable{
    private String mobileID;
    private String mobileName;
    private String description;
    private String price;
    private String yom;
    private boolean notSale;
    private String quantity;

    public Tbl_MobileDTO(String mobileID, String mobileName, String description, String price, String yom, boolean notSale, String quantity) {
        this.mobileID = mobileID;
        this.mobileName = mobileName;
        this.description = description;
        this.price = price;
        this.yom = yom;
        this.notSale = notSale;
        this.quantity = quantity;
    }

    public Tbl_MobileDTO(String mobileID, String mobileName, String description, String price, String yom, boolean notSale) {
        this.mobileID = mobileID;
        this.mobileName = mobileName;
        this.description = description;
        this.price = price;
        this.yom = yom;
        this.notSale = notSale;
    }

    
    

    public String getMobileID() {
        return mobileID;
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

    public boolean isNotSale() {
        return notSale;
    }

    public void setNotSale(boolean notSale) {
        this.notSale = notSale;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }
    
    
    
}
