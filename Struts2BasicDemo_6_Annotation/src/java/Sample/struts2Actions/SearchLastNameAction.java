/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sample.struts2Actions;

import Sample.registration.RegistrationDAO;
import Sample.registration.RegistrationDTO;
import java.util.List;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;
import org.apache.struts2.convention.annotation.Results;

/**
 *
 * @author PhongNTSE1997
 */
@ResultPath("/")
@Results({
    @Result(location = "search.jsp")
})
public class SearchLastNameAction {
    private final String SUCCESS = "success";
    private String searchValue;
    private List<RegistrationDTO> listaccount;

    public List<RegistrationDTO> getListaccount() {
        return listaccount;
    }
    
    public SearchLastNameAction() {
    }
    @Action("search")
    public String execute() throws Exception {
        RegistrationDAO dao = new RegistrationDAO();
        dao.searchLastName(searchValue);
        this.listaccount = dao.getListAcc();
        return SUCCESS;
    }

    public String getSearchValue() {
        return searchValue;
    }

    public void setSearchValue(String searchValue) {
        this.searchValue = searchValue;
    }
    

    
    
}
