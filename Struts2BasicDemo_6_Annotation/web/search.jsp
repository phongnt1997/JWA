<%-- 
    Document   : search
    Created on : Oct 17, 2017, 8:05:22 AM
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
        Welcome, <s:property value="%{#session.USERNAME}" /> 

        </font>
        <s:form action="search">
            <s:textfield name="searchValue" label="Search value"/>
            <s:submit value="search"/>    
        </s:form><br/>
        
        <s:if test="%{searchValue != '' and searchValue != null}">
            <s:if test="%{listaccount != null}">
                <table border="1">
                    <thead>
                        <tr>
                            <th>No.</th>
                            <th>Username</th>
                            <th>Password</th>
                            <th>Lastname</th>
                            <th>Role</th>
                            <th>Delete</th>
                            <th>Update</th>
                        </tr>
                    </thead>
                    <tbody>
                        <s:iterator value="listaccount" status="counter">
                            <s:form action="update" theme="simple">
                                <tr>
                            <td>
                                <s:property value="%{#counter.count}"/>
                            </td>
                            <td>
                                <s:property value="username"/>
                                <s:hidden name="pk" value="%{username}"/>
                            </td>
                            <td>
                                <s:textfield name="password" value="%{password}"/>
                            </td>
                            <td>
                                <s:property value="lastname"/>
                            </td>
                            <td>
                                
                                <s:checkbox name="admin" value="%{role=='admin'}"/>
                            </td>
                            <td>
                                <s:url id="delLink" action="delete">
                                    <s:param name="pk" value="username"/>
                                    <s:param name="lastSearchValue" value="searchValue"/>
                                </s:url>
                                <s:a href="%{delLink}">Delete</s:a>
                                </td>
                                <td>
                                <s:hidden name="lastSearchValue" value="%{searchValue}"/>
                                <s:submit value="Update"/>
                            </td>
                            </tr>
                        </s:form>
                    </s:iterator>                        
                </tbody>
            </table>

        </s:if>
    </s:if>
</body>
</html>
