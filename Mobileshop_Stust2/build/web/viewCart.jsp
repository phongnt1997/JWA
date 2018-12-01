<%-- 
    Document   : viewCart
    Created on : Oct 21, 2017, 8:03:29 AM
    Author     : PhongNTSE1997
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cart</title>
        <s:head/>
    </head>
    <body>
        <h1>Your Cart</h1>

        <s:if test="%{#session.CART != null && #session.CART.items.size() > 0}"> 
            <table border="1">
                <thead>
                    <tr>
                        <th>No.</th>
                        <th>Name</th>
                        <th>Quantity</th>
                        <th>Price</th>
                        <th>Remove</th>
                    </tr>
                </thead>
                <tbody>
                    <s:iterator var="entry" value="%{#session.CART.items}" status="counter">
                        <s:set var="dto" value="%{#entry.value}"/>
                        <s:form action="removeItem" theme="simple">
                            <tr>
                                <td>
                                    <s:property value="%{#counter.count}"/>

                                </td>
                                <td>
                                    <s:property value="%{#dto.mobileName}"/>
                                    <s:hidden name="mobileID" value="%{#dto.mobileID}" />
                                   
                                </td>
                                <td>
                                    <s:property value="%{#dto.quantity}"/>
                                </td>
                                <td>
                                    <s:property value="%{#dto.price}"/>
                                </td>
                                <td>
                                    <s:submit value="Remove"/>
                                </td>
                            </tr>
                        </s:form>
                    </s:iterator>
                    <tr>
                        <td colspan="4">
                            Total: <s:property value="%{#session.CART.total}"/>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="4">
                            <s:form action="checkOut">
                                <s:submit value="checkOut"/>
                                <s:hidden name="userID" value="%{#session.ACTOR.userID}" />
                            </s:form>
                        </td>
                    </tr>
                </tbody>
            </table>


        </s:if>
        <s:if test="%{#session.CART == null || #session.CART.items == null}">
            <h2>Your cart is empty</h2>
        </s:if>
        <s:a href="user.jsp">Click to buy more</s:a>
    </body>
</html>
