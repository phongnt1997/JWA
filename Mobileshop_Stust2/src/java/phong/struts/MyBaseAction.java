/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phong.struts;

import com.opensymphony.xwork2.Action;

/**
 *
 * @author PhongNTSE1997
 */
public class MyBaseAction implements Action{
    private Object userService;
    @Override
    public String execute() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Object getUserService() {
        return userService;
    }

    public void setUserService(String userService) {
        this.userService = userService;
    }
    
}
