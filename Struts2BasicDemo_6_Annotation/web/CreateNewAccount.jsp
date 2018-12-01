<%-- 
    Document   : CreateNewAccount
    Created on : Sep 28, 2017, 8:50:36 AM
    Author     : PhongNTSE1997
--%>

<%@page import="Sample.registration.RegistrationError"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Create New Account</h1>
        <form action="DispathServlet" method="POST">
            <c:set var="error" value="${requestScope.CREATEERROR}"/>
            username* <input type="text" name="txtUsername"/>(6 - 12 chars)<br/>
            <c:if test="${not empty error.usernameLengthErr}">
                <font color="red">
                    ${error.usernameLengthErr}
                </font><br/>
            </c:if>
            Password* <input type="text" name="txtPassword"/>(8 -30 chars)<br/>
            <c:if test="${not empty error.passwordLengthErr}">
                <font color="red">
                    ${error.passwordLengthErr}
                </font><br/>
            </c:if>
            Confirm* <input type="text" name="txtConfirm"/><br/>
            <c:if test="${not empty error.confirmNoMatch}">
                <font color="red">
                    ${error.confirmNoMatch}
                </font><br/>
            </c:if>
            Fullname* <input type="text" name="txtFullname"/>(2 - 30 chars)<br/>
            <c:if test="${not empty error.fullnameLengthErr}">
                <font color="red">
                    ${error.fullnameLengthErr}
                </font><br/>
            </c:if>
            <input type="submit" name="btAction" value="CreateAccount"/>
        </form><br/>
        <s:if test="%{exception.message.contains('dupicate')}">
            <font color="red">
            <s:property value="username"/> is existed!!
            </font>
        </s:if>
        <c:if test="${not empty error.usernameExisted}">
                <font color="red">
                    ${error.usernameExisted}
                </font><br/>
            </c:if>
        
        
        
        
   <%--     <form action="DispathServlet" method="POST">
            username* <input type="text" name="txtUsername" value="<%= request.getParameter("txtUsername") %>"/>(6 - 12 chars)<br/>
            <% 
                RegistrationError error = (RegistrationError) request.getAttribute("CREATEERROR");
                if(error != null) {
                    if(error.getUsernameLengthErr() != null) {
                    %>
            
                    <font color="red">
                        <%= error.getUsernameLengthErr() %>
                    </font><br/>
            
            
            
            
            <%
                }
               }
            %>
            Password* <input type="text" name="txtPassword" />(8 -30 chars)<br/>
             <% 
                if(error.getPasswordLengthErr() != null) {
                if(error != null) {
                    %>
            
                    <font color="red">
                        <%= error.getPasswordLengthErr() %>
                    </font><br/>
            <%
                }
}
            %>
            Confirm* <input type="text" name="txtConfirm"/><br/>
             <% 
                if(error.getConfirmNoMatch() != null) {
                if(error != null) {
                    %>
            
                    <font color="red">
                        <%= error.getConfirmNoMatch() %>
                    </font><br/>
            <%
                }
}
            %>
            Fullname* <input type="text" name="txtFullname" value="<%= request.getParameter("txtUsername") %>"/>(2 - 30 chars)<br/>
             <% 
                if(error.getFullnameLengthErr() != null) {
                if(error != null) {
                    %>
            
                    <font color="red">
                        <%= error.getFullnameLengthErr() %>
                   </font><br/>
            <%
                }
}
            %>
            <input type="submit" name="btAction" value="CreateAccount"/>
        </form>
             <% 
                if(error.getUsernameExisted() != null) {
                if(error != null) {
                    %>
            
                    <font color="red">
                        <%= error.getUsernameExisted() %>
                    </font><br/>
            <%
                }
                }
            %> --%>
    </body>
</html>
