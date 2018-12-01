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
import phong.product.ErrorObj;
import phong.product.Tbl_productDAO;
import phong.product.Tbl_productDTO;

/**
 *
 * @author PhongNTSE1997
 */
public class UpdateProductServlet extends HttpServlet {

    private final String productPage = "product.jsp";
    private final String updateErrPage = "error.html";
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
        String url = updateErrPage;
        try {
            /* TODO output your page here. You may use following sample code. */
            HttpSession session = request.getSession(false);
            if (session != null) {
                ErrorObj errObj = new ErrorObj();
                boolean err = false;
                String pk = request.getParameter("pk");
                String price = request.getParameter("txtPrice");
                if (price.equals("0") || !price.matches("[0-9]+\\.?[0-9]*")) {
                    err = true;
                    errObj.setPriceFormatErr("Price must be number and greater than 0");
                }
                String unit = request.getParameter("txtUnit");
                if (unit.length() < 2 || unit.length() > 20) {
                    err = true;
                    errObj.setUnitLengthErr("Unit name required 2 - 20 chars");
                }
                if (!err) {
                    Tbl_productDAO dao = new Tbl_productDAO();
                    boolean result = dao.updateProduct(pk, price, unit);
                    if (result) {
                        dao.makeListItems();
                        List<Tbl_productDTO> items = dao.getItems();

                        session.setAttribute("ITEMS", items);
                        session.setAttribute("MSG", "Update Success!!!");
                        url = productPage;
                    }
                } else {
                    request.setAttribute("UPDATEERROR", errObj);
                    url = productPage;
                }
            }else {
                url = loginPage;
            }
            
        } catch (SQLException ex) {
            log("SQLException-Update: " + ex.getMessage());

        } catch (NamingException ex) {
            log("NamingException-Update: " + ex.getMessage());
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
