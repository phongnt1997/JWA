/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phong.struts2;

import com.opensymphony.xwork2.ActionContext;
import java.util.Map;
import phong.login.LoginDAO;

/**
 *
 * @author PhongNTSE1997
 */
public class LoginAction {
    private String username;
    private String password;
    private final String FAIL = "fail";
    private final String SUCCESS = "success";
    public LoginAction() {
    }
    
    public String execute() throws Exception {
        LoginDAO dao = new LoginDAO();
        boolean result = dao.checkLogin(username, password);
        String url = FAIL;
        if(result) {
            Map session = ActionContext.getContext().getSession();
            session.put("USERNAME", getUsername());
            
            url = SUCCESS;
        }
        return url;
    }
  
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
}
