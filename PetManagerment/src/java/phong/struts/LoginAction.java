/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phong.struts;

import com.opensymphony.xwork2.ActionContext;
import java.util.Map;
import phong.user.Tbl_UserDAO;

/**
 *
 * @author PhongNTSE1997
 */
public class LoginAction {
    private String username;
    private String password;
    private final String SUCCESS = "success";
    private final String FAIL = "fail";
    public LoginAction() {
    }
    
    public String execute() throws Exception {
        Tbl_UserDAO dao = new Tbl_UserDAO();
        Map session = ActionContext.getContext().getSession();
        boolean result = dao.checkLogin(username, password);
        String url = FAIL;
        if(result) {
            url = SUCCESS;
            session.put("USERNAME", username);
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
