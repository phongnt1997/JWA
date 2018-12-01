/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phong.struts;

import java.util.List;
import phong.pet.tbl_PetDAO;
import phong.pet.tbl_PetDTO;

/**
 *
 * @author PhongNTSE1997
 */
public class SearchPetAction {
    private String searchValue;
    private List<tbl_PetDTO> listPet;
    private final String SUCCESS = "success";
    
    public SearchPetAction() {
    }
    
    public String execute() throws Exception {
        tbl_PetDAO dao = new tbl_PetDAO();
        dao.searchPetbyName(searchValue);
        listPet = dao.getListPet();
        return SUCCESS;
    }

    public String getSearchValue() {
        return searchValue;
    }

    public void setSearchValue(String searchValue) {
        this.searchValue = searchValue;
    }

    public List<tbl_PetDTO> getListPet() {
        return listPet;
    }

    public void setListPet(List<tbl_PetDTO> listPet) {
        this.listPet = listPet;
    }
    
}
