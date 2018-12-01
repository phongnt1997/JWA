<%-- 
    Document   : index
    Created on : Oct 28, 2017, 2:18:43 PM
    Author     : PhongNTSE1997
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <s:head/>
    </head>
    <body>
        <h1>Login Page</h1>
        <s:form action="login" method="POST">
            Username <s:textfield name="username" value="" /><br/>
            Password <s:password name="password" value="" /><br/>
           
            <s:submit value="Login" />
            <s:reset value="Reset" />
        </s:form>

    </body>
</html>
