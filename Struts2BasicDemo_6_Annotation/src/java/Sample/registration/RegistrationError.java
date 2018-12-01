/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sample.registration;

import java.io.Serializable;

/**
 *
 * @author PhongNTSE1997
 */
public class RegistrationError implements Serializable{
    private String usernameLengthErr;
    private String passwordLengthErr;
    private String fullnameLengthErr;
    private String confirmNoMatch;
    private String usernameExisted;
    private String roleIsWrong;
    private String phoneFotmatErr;

    public String getPhoneFotmatErr() {
        return phoneFotmatErr;
    }

    public void setPhoneFotmatErr(String phoneFotmatErr) {
        this.phoneFotmatErr = phoneFotmatErr;
    }

    public String getRoleIsWrong() {
        return roleIsWrong;
    }

    public void setRoleIsWrong(String roleIsWrong) {
        this.roleIsWrong = roleIsWrong;
    }
    
    
    

    public String getUsernameLengthErr() {
        return usernameLengthErr;
    }

    public void setUsernameLengthErr(String usernameLengthErr) {
        this.usernameLengthErr = usernameLengthErr;
    }

    public String getPasswordLengthErr() {
        return passwordLengthErr;
    }

    public void setPasswordLengthErr(String passwordLengthErr) {
        this.passwordLengthErr = passwordLengthErr;
    }

    public String getFullnameLengthErr() {
        return fullnameLengthErr;
    }

    public void setFullnameLengthErr(String fullnameLengthErr) {
        this.fullnameLengthErr = fullnameLengthErr;
    }

    public String getConfirmNoMatch() {
        return confirmNoMatch;
    }

    public void setConfirmNoMatch(String confirmNoMatch) {
        this.confirmNoMatch = confirmNoMatch;
    }

    public String getUsernameExisted() {
        return usernameExisted;
    }

    public void setUsernameExisted(String usernameExisted) {
        this.usernameExisted = usernameExisted;
    }
    
    
}
