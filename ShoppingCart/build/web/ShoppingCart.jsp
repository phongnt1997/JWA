<%-- 
    Document   : ShoppingCart
    Created on : Aug 11, 2017, 9:44:10 AM
    Author     : PhongNTSE1997
--%>

<%@page import="dtos.ProductDTO"%>
<%@page import="dtos.CartObj"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            CartObj cart = (CartObj) session.getAttribute("cart");
            if(cart != null) {
                
        %>
        
        
        <h1><%= cart.getCustomerName() %>'s cart</h1>
        
        <form action="MainController" method="POST">
        <table border="1">
            <thead>
                <tr>
                    <th>No</th>
                    <th>ProName</th>
                    <th>Quantity</th>
                    <th>Price</th>
                    <th>Remove</th>
                </tr>
            </thead>
            <tbody>
                <%
                    int i = 0;    
                    for (ProductDTO dto : cart.getCart().values()) {
                            i++;
                        
                     
                %>
                <tr>
                    <td><%= i %></td>
                    <td><%= dto.getName() %></td>
                    <td>
                        <input type="hidden" name="txtId" value="<%= dto.getId() %>"/>
                        <input type="text" name="txtQuantity" value="<%= dto.getQuantity() %>"/>
                        
                    <td><%= dto.getPrice() %></td>
                    <td>
                        <input type="checkbox" name="chkID" value="<%= dto.getId() %>"/>
                                
                    </td>
                </tr>
                <%}%>
                <tr>
                    <td>
                        <%= cart.gettotal() %>
                    </td>
                </tr>
            </tbody>
        </table>
                 

        <%
        } else  {
                    
        %>
                your cart is not exist!
        <%
                }
        
        %>
        <a href="index.html"> continue </a>
        <input type="submit" name="action" value="Remove"/>
        <input type="submit" name="action" value="Update"/>
        </form>
    </body>
</html>
