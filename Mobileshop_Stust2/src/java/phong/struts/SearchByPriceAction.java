/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phong.struts;

import java.util.List;
import phong.mobile.Tbl_MobileDAO;
import phong.mobile.Tbl_MobileDTO;

/**
 *
 * @author PhongNTSE1997
 */
public class SearchByPriceAction {
    private String minPrice;
    private String maxPrice;
    private List<Tbl_MobileDTO> listMobile;
    private final String SUCCESS = "success";
    public SearchByPriceAction() {
    }

    public List<Tbl_MobileDTO> getListMobile() {
        return listMobile;
    }

    public void setListMobile(List<Tbl_MobileDTO> listMobile) {
        this.listMobile = listMobile;
    }
    
    public String getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(String minPrice) {
        this.minPrice = minPrice;
    }

    public String getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(String maxPrice) {
        this.maxPrice = maxPrice;
    }
    
    public String execute() throws Exception {
        Tbl_MobileDAO dao = new Tbl_MobileDAO();
        dao.searchByPrice(minPrice, maxPrice);
        listMobile = dao.getListMobile();
        return SUCCESS;
    }
    
}
