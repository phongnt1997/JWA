/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phong.struts;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;
import java.util.Map;
import java.util.Stack;
import phong.user.Tbl_UserDAO;
import phong.user.Tbl_UserDTO;

/**
 *
 * @author PhongNTSE1997
 */
public class LoginAction extends ActionSupport{
    private String username;
    private String password;
    
    public LoginAction() {
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
    
    public String execute() throws Exception {
        Tbl_UserDAO dao = new Tbl_UserDAO();
        Tbl_UserDTO userService = dao.checkLogin(username, password);
        Map session = ActionContext.getContext().getSession();
        ValueStack x = ActionContext.getContext().getValueStack();
        
        x.push(userService);
        session.put("ACTOR", userService);
        return Integer.toString(userService.getRole());
    }
    
    @Override
    public void validate() {
        if(this.username.length() == 0) {
            addFieldError("username", "Username is required");
        }
        if(this.password.length() == 0) {
            addFieldError("password", "Password is required");
        }
    }
    
}

