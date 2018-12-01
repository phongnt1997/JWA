/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phong.struts2;

import java.util.List;
import phong.login.LoginDAO;
import phong.login.LoginDTO;

/**
 *
 * @author PhongNTSE1997
 */
public class SearchAction {
    private String searchValue;
    private List<LoginDTO> listAcc;
    private final String SUCCESS ="success";
    
    public SearchAction() {
    }
    
    public String execute() throws Exception {
        LoginDAO dao = new LoginDAO();
        dao.searchValue(searchValue);
        listAcc = dao.getListAcc();
        System.out.println("asdasdasdasd");
        return SUCCESS;
    }

    public String getSearchValue() {
        return searchValue;
    }

    public void setSearchValue(String searchValue) {
        this.searchValue = searchValue;
    }

    public List<LoginDTO> getListAcc() {
        return listAcc;
    }

    public void setListAcc(List<LoginDTO> listAcc) {
        this.listAcc = listAcc;
    }
    
}
