/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import daos.DAO;
import dtos.DTO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.DynaActionForm;

/**
 *
 * @author PhongNTSE1997
 */
public class InsertAction extends org.apache.struts.action.Action {

    /* forward name="success" path="" */
    private static final String SUCCESS = "success";
    private static final String FAIL = "fail";

    /**
     * This is the action called from the Struts framework.
     *
     * @param mapping The ActionMapping used to select this instance.
     * @param form The optional ActionForm bean for this request.
     * @param request The HTTP Request we are processing.
     * @param response The HTTP Response we are processing.
     * @throws java.lang.Exception
     * @return
     */
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        String url = FAIL;
        DynaActionForm dyna = (DynaActionForm) form;
        String username = dyna.getString("username");
        String password = dyna.getString("password");
        String fullname = dyna.getString("emailId");
        String role = dyna.getString("phoneNo");
        DTO dto = new DTO(username, password, fullname, role);
        DAO dao = new DAO();
        if(dao.insert(dto)) {
            url = SUCCESS;
        }
        return mapping.findForward(url);
    }
}
