/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phong.struts;

import phong.mobile.Tbl_MobileDAO;

/**
 *
 * @author PhongNTSE1997
 */
public class DeleteMobileAction {
    private String pk;
    private String lastSearchValue;
    private final String Fail = "fail";
    private final String Success = "success";
    public DeleteMobileAction() {
    }

    public String getPk() {
        return pk;
    }

    public void setPk(String pk) {
        this.pk = pk;
    }

    public String getLastSearchValue() {
        return lastSearchValue;
    }

    public void setLastSearchValue(String lastSearchValue) {
        this.lastSearchValue = lastSearchValue;
    }
    
    public String execute() throws Exception {
        Tbl_MobileDAO dao = new Tbl_MobileDAO();
        boolean result = dao.deleteMobile(pk);
        String url = Fail;
        if(result) {
            url = Success;
        }
        return url;
    }
    
}
