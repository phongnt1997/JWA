/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phong.struts;

import com.opensymphony.xwork2.ActionContext;
import java.util.Map;
import phong.cart.CartObj;
import phong.mobile.Tbl_MobileDTO;

/**
 *
 * @author PhongNTSE1997
 */
public class AddToCartAction {
    private String minSearchValue;
    private String maxSearchValue;
    private String mobileID;
    private String mobileName;
    private String description;
    private String price;
    private String yom;
    private boolean notSale;
    private CartObj cartobj;
    private final String SUCCESS = "success";
    public AddToCartAction() {
    }

    public String getMinSearchValue() {
        return minSearchValue;
    }

    public void setMinSearchValue(String minSearchValue) {
        this.minSearchValue = minSearchValue;
    }

    public String getMaxSearchValue() {
        return maxSearchValue;
    }

    public void setMaxSearchValue(String maxSearchValue) {
        this.maxSearchValue = maxSearchValue;
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

    public CartObj getCartobj() {
        return cartobj;
    }

    public void setCartobj(CartObj cartobj) {
        this.cartobj = cartobj;
    }
    
    public String execute() throws Exception {
       Map session = ActionContext.getContext().getSession();
       
            cartobj = (CartObj) session.get("CART");
            if(cartobj == null){
                cartobj = new CartObj();
            }
            
            Tbl_MobileDTO dto = new Tbl_MobileDTO(mobileID, mobileName, description, price, yom, notSale);
            cartobj.addItemToCart(mobileID, dto);
            session.put("CART", cartobj);

        return SUCCESS;
        
    }
    
}
