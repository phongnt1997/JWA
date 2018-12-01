/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phong.account;

import java.io.Serializable;

/**
 *
 * @author PhongNTSE1997
 */
public class Tbl_accountDTO implements Serializable{
    private String username;
    private String password;
    private String employeeName;
    private String expired;

    public Tbl_accountDTO(String username, String password, String employeeName, String expired) {
        this.username = username;
        this.password = password;
        this.employeeName = employeeName;
        this.expired = expired;
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

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getExpired() {
        return expired;
    }

    public void setExpired(String expired) {
        this.expired = expired;
    }
    
}
