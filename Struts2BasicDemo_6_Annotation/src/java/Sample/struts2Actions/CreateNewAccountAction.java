/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sample.struts2Actions;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.StringLengthFieldValidator;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ExceptionMapping;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;
import org.apache.struts2.convention.annotation.Results;

/**
 *
 * @author PhongNTSE1997
 */
@ResultPath
@Results({
    @Result(location = "login.html"),
    @Result(name = "fail", location ="errorPage.html"),
    @Result(name = "success", location ="search.jsp"),
})
public class CreateNewAccountAction extends ActionSupport{
    private String username;
    private String password;
    private String confirm;
    public CreateNewAccountAction() {
    }
    @Action(value = "createAccount",
            exceptionMappings = {
                @ExceptionMapping(exception = "java.sql.SQLException", result = "input")
            }
            )
    public String execute() throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    @RequiredStringValidator(message = "Username is required!!!", key = "createAcount.username.required")
    @StringLengthFieldValidator(minLength = "2", maxLength = "20", message = "Username is required 2 -50 chars",
                key = "createAccount.username.length")

    public String getUsername() {
        return username;
    }
    
    
    
}
