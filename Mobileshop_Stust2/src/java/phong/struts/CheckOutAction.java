/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phong.struts;

import com.opensymphony.xwork2.ActionContext;
import java.util.Map;
import phong.cart.CartObj;
import phong.mobile.Tbl_MobileDAO;
import phong.user.Tbl_UserDAO;

/**
 *
 * @author PhongNTSE1997
 */
public class CheckOutAction {
    private final String SUCCESS = "success";
    private String userID;
    private String MSG;
    public CheckOutAction() {
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getMSG() {
        return MSG;
    }

    public void setMSG(String MSG) {
        this.MSG = MSG;
    }
    
    public String execute() throws Exception {
        Map session = ActionContext.getContext().getSession();
        CartObj cart = (CartObj)session.get("CART");
        cart.setCustomerID(userID);
        Tbl_MobileDAO dao = new Tbl_MobileDAO();
        boolean result = dao.checkOut(cart);
        if(result) {
            MSG = "Checkout success";
            session.remove("CART");
        }else {
            MSG = "Checkout fail";
        }
        return SUCCESS;
    }
    
}
