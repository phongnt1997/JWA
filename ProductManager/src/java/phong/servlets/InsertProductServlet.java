/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phong.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import phong.account.Tbl_accountDTO;
import phong.product.ErrorObj;
import phong.product.Tbl_productDAO;
import phong.product.Tbl_productDTO;

/**
 *
 * @author PhongNTSE1997
 */
public class InsertProductServlet extends HttpServlet {

    private final String inserrErrPage = "insertErr.html";
    private final String productPage = "product.jsp";
    private final String loginPage = "login.html";

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String url = inserrErrPage;
        ErrorObj errObj = new ErrorObj();
        boolean err = false;

        /* TODO output your page here. You may use following sample code. */
        String id = request.getParameter("txtID").trim();
        if (id.length() < 2 || id.length() > 10) {
            err = true;
            errObj.setIdLengthErr("productID required 2 - 10 chars");
        }
        String name = request.getParameter("txtName").trim();
        if (name.length() < 2 || name.length() > 50) {
            err = true;
            errObj.setNameLengthErr("product name required 2 - 50 chars");
        }
        String unit = request.getParameter("txtUnit").trim();
        if (unit.length() < 2 || unit.length() > 20) {
            err = true;
            errObj.setUnitLengthErr("Unit name required 2 - 20 chars");
        }
        try {
            HttpSession session = request.getSession(false);
            if (session != null) {
                if (!err) {
                    Tbl_productDTO dto = new Tbl_productDTO(id, name, unit);
                    Tbl_productDAO dao = new Tbl_productDAO();
                    boolean result = dao.insertProduct(id, name, unit);
                    if (result) {
                        url = productPage;
                        dao.makeListItems();
                        List<Tbl_productDTO> items = dao.getItems();

                        session.setAttribute("ITEMS", items);
                        request.setAttribute("MSG", "Insert success!!!");
                    }
                } else {
                    request.setAttribute("INSERTERROR", errObj);
                    url = productPage;
                }
            }else {
                url = loginPage;
            }
            
        } catch (SQLException ex) {
            log("SQLException_insert: " + ex.getMessage());
            String msg = ex.getMessage();
            if (msg.contains("duplicate")) {
                errObj.setIdExistedErr(id + " is existed");
                request.setAttribute("INSERTERROR", errObj);
            }

        } catch (NamingException ex) {
            log("NamingException_insert: " + ex.getMessage());
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
