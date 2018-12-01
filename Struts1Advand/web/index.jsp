<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="html" uri="/WEB-INF/struts-html.tld" %>
<%@taglib prefix="logic" uri="/WEB-INF/struts-logic.tld" %>

<html>
    <body>
        <html:form action="/Insert" method="post" onsubmit="return validateinsertActionForm">
            Username: <html:text property="username"/>
            <br/>
            Password: <html:password property="password"/>
            <br/>
            Email: <html:text property="emailId"/>
            <br/>
            PhoneNo: <html:text property="phoneNo"/>
            
        </html:form>
    </body>
</html>