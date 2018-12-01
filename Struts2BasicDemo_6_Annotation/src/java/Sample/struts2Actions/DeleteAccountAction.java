/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sample.struts2Actions;

import Sample.registration.RegistrationDAO;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;
import org.apache.struts2.convention.annotation.Results;

/**
 *
 * @author PhongNTSE1997
 */
@ResultPath
@Results({
    @Result(type ="redirectAction", params= {
        "actionName", "search", "searchValue", "${lastSearchValue}"
    }),
    @Result (name = "fail", location ="errorPage.html")
})
public class DeleteAccountAction {
    private String pk;
    private String lastSearchValue;
    private final String SUCCESS = "success";
    private final String FAIL = "fail";
    
    
    public DeleteAccountAction() {
    }
    @Action("delete")
    public String execute() throws Exception {
        RegistrationDAO dao = new RegistrationDAO();
        boolean result = dao.deleteAccount(pk);
        if(result) return SUCCESS;
        else return FAIL;
                
    }
    
}
