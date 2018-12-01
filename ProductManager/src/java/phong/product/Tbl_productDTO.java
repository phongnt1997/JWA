/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phong.product;

import java.io.Serializable;

/**
 *
 * @author PhongNTSE1997
 */
public class Tbl_productDTO implements Serializable {

    private String productID;
    private String productName;
    private String price;
    private String quantity;
    private String unit;

    

    public Tbl_productDTO(String productID, String productName, String unit) {
        this.productID = productID;
        this.productName = productName;
        this.unit = unit;
    }

    public Tbl_productDTO(String productID, String productName, String price, String quantity, String unit) {
        this.productID = productID;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
        this.unit = unit;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
    

    
    
    
    
}
 