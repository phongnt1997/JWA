<%-- 
    Document   : insert
    Created on : Oct 29, 2017, 6:10:02 PM
    Author     : PhongNTSE1997
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Insert</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <h1>Insert Page</h1>
        <s:property value="%{MSG}"/>
        <s:form action="insertMobile" theme="simple">
            MobileID <s:textfield name="mobileID"/>(3 - 10 chars)<br/>
            Description <s:textfield name="description"/>(3 - 50 chars)<br/>
            Mobile Name <s:textfield name="mobileName"/>(3 - 20 chars)<br/>
            Price <s:textfield name="price"/><br/>
            Year of mobile <s:textfield name="yom"/><br/>
            Quantity <s:textfield name="quantity" /><br/>
            <s:submit value="Insert"/>
            <s:reset value="Reset"/>
        </s:form>
        <a href="staff.jsp">Back to Staff Page</a>
    </body>
</html>