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
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import phong.account.Tbl_accountDAO;
import phong.account.Tbl_accountDTO;
import phong.product.Tbl_productDAO;
import phong.product.Tbl_productDTO;

/**
 *
 * @author PhongNTSE1997
 */
public class LoginServlet extends HttpServlet {
private final String productpage = "product.jsp";
private final String invalid = "invalid.html";
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
        String url = invalid;
        try {
            /* TODO output your page here. You may use following sample code. */
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            Tbl_accountDAO dao = new Tbl_accountDAO();
            Tbl_accountDTO dto = dao.checkLogin(username, password);
            if(dto != null) {
                HttpSession session = request.getSession();
                session.setAttribute("ACTOR", dto);
                Tbl_productDAO pdao = new Tbl_productDAO();
                pdao.makeListItems();
                List<Tbl_productDTO> items = pdao.getItems();
                if(items!=null) {
                    session.setAttribute("ITEMS", items);
                }
                else {
                    request.setAttribute("ITEMS", "The items empty");
                }
                url = productpage;
                
            }
        }catch (SQLException ex){
            log("SQLException_Login: " + ex.getMessage());
        
        }catch (NamingException ex){
            log("NamingException_Login: " + ex.getMessage());
        }
        
        finally {
            RequestDispatcher rd = request.getRequestDispatcher(url);
            rd.forward(request, response);
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
