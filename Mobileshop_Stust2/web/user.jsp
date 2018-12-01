<%-- 
    Document   : user
    Created on : Oct 18, 2017, 10:40:40 AM
    Author     : PhongNTSE1997
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User</title>
    </head>
    <body>
        <h1>User page</h1>
        <font color="red">
        welcome, <s:property value="%{#session.ACTOR.fullname}"/><br/>
        <s:property value="%{MSG}"/><br/>
        </font>
        <s:a href="logout">Logout</s:a>
        <s:form action="searchByPrice" theme="simple">
            Search by Price<br/>
            Min <s:textfield name="minPrice"/>
            Max <s:textfield name="maxPrice"/>
            <s:submit value="Search" />
        </s:form>
        
        
        <s:a href="viewCart.jsp">View your cart</s:a>
        <s:if test="%{minPrice.trim().length() > 0 || maxPrice.trim().length() > 0}">
            <s:if test="%{listMobile != null}">
                <table border="1">
                    <thead>
                        <tr>
                            <th>No.</th>
                            <th>MobileID</th>
                            <th>Description</th>
                            <th>MobileName</th>
                            <th>Price</th>
                            <th>YearOfProduct</th>
                            <th>Quantity</th>
                            <th>NotSale</th>
                            <th>Add to cart</th>
                        </tr>
                    </thead>
                    <tbody>
                        <s:iterator value="%{listMobile}" status="counter">
                            <s:form action="addToCart" theme="simple">
                            <tr>
                                <td>
                                    <s:property value="%{#counter.count}"/>
                                </td>
                                <td><s:property value="mobileID"/>
                                    <s:hidden name="mobileID" value="%{mobileID}" />
                            </td>
                            <td><s:property value="description"/>
                                <s:hidden name="description" value="%{description}" />
                            </td>
                            <td><s:property value="mobileName"/>
                                <s:hidden name="mobileName" value="%{mobileName}" />
                            </td>
                            <td><s:property value="price"/>
                                <s:hidden name="price" value="%{price}" />
                            </td>
                            <td><s:property value="yom"/>
                                <s:hidden name="yom" value="%{yom}" />
                            </td>
                            <td><s:property value="%{quantity}"/></td>
                            <td>
                                <s:checkbox name="notSale" value="notSale"/>
                            </td>
                            <td>
                                <s:submit value="Buy" />
                                <s:hidden name="minSearchValue" value="%{minPrice}" />
                                <s:hidden name="maxSearchValue" value="%{maxPrice}" />
                            </td>
                           
                        </tr>
                        </s:form>
                            
                        </s:iterator>>
                        
                        
                    </tbody>
                </table>

            </s:if>
            <s:if test="%{listMobile == null}">
                <h2>No record matched!!</h2>
            </s:if>
        </s:if>
    </body>
</html>
