<%-- 
    Document   : search
    Created on : Oct 25, 2017, 12:52:41 PM
    Author     : PhongNTSE1997
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search</title>
    </head>
    <body>
        <font color="red">
        Welcome, <s:property value="%{#session.USERNAME}"/>
        </font>
        <h1>Search page</h1>
        <s:form action="search">
            <s:textfield name="searchValue" label="Search Value"/><br/>
            <s:submit value="Search"/>
        </s:form><br/>
        <s:if test="%{searchValue != '' and searchValue != null}">
            <s:if test="%{listAcc != null}">
                Result of search <br/>
                <table border="1">
                    <thead>
                        <tr>
                            <th>No.</th>
                            <th>Username</th>
                            <th>Password</th>
                            <th>Lassname</th>
                            <th>Role</th>
                            <th>Delete</th>
                            <th>Update</th>
                        </tr>
                    </thead>
                    <tbody>
                        <s:iterator value="listAcc" status="counter">
                            <tr>
                                <td>
                                    <s:property value="%{#counter.count}"/>
                                </td>
                                <td>
                                    <s:property value="username"/>
                                </td>
                            </tr>
                        </s:iterator>
                        
                    </tbody>
                </table>

            </s:if>
        </s:if>
    </body>
</html>
