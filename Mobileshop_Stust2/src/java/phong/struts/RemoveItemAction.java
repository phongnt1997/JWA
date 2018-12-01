/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phong.struts;

import com.opensymphony.xwork2.ActionContext;
import java.util.Map;
import phong.cart.CartObj;

/**
 *
 * @author PhongNTSE1997
 */
public class RemoveItemAction {
    private String mobileID;
    private final String SUCCESS = "success";
    public RemoveItemAction() {
    }

    public String getMobileID() {
        return mobileID;
    }

    public void setMobileID(String mobileID) {
        this.mobileID = mobileID;
    }
    
    public String execute() throws Exception {
        Map session = ActionContext.getContext().getSession();
        
            CartObj cart = (CartObj) session.get("CART");
            cart.removeItemFromCart(mobileID);
            session.put("CART", cart);
        
        return SUCCESS;
    }
    
}
