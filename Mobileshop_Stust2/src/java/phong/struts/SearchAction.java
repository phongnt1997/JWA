/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phong.struts;

import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
import phong.mobile.Tbl_MobileDAO;

/**
 *
 * @author PhongNTSE1997
 */
public class SearchAction extends ActionSupport{
    private String searchValue;
    private List listMobile;
    private String minPrice;
    private String maxPrice;
    
    private final String staffPage = "staff";
    private final String userPage = "user";
    public SearchAction() {
    }

    public String getSearchValue() {
        return searchValue;
    }

    public void setSearchValue(String searchValue) {
        this.searchValue = searchValue;
    }

    public List getListMobile() {
        return listMobile;
    }

    public void setListMobile(List listMobile) {
        this.listMobile = listMobile;
    }
    
   
    public String searchPrice() throws Exception {
        Tbl_MobileDAO dao = new Tbl_MobileDAO();
        dao.searchByPrice(minPrice, maxPrice);
        listMobile = dao.getListMobile();
        return userPage;
    }
    
    public String execute() throws Exception {
        Tbl_MobileDAO dao = new Tbl_MobileDAO();
        dao.searchByIDOrName(searchValue);
        listMobile = dao.getListMobile();
        return staffPage;
    }
    
}
