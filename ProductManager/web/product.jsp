<%-- 
    Document   : product
    Created on : Oct 22, 2017, 9:56:17 AM
    Author     : PhongNTSE1997
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<style>
    div {float: left}
    #view {width: 60%; padding-left: 50px; box-sizing: border-box; border-left: black thin solid}
    #insert {width: 35%; margin-right: 50px}
</style>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Product</title>
    </head>
    <body>
        <h1>Product Page</h1>
        <a href="logout">Logout</a><br/>
        <font color="red">
        Welcome, ${sessionScope.ACTOR.employeeName}<br/>
        ${requestScope.MSG}

        </font>
        <div id="insert">
            <fieldset>
                <legend style="color:blue;font-weight:bold;">Insert new product</legend>
                <table>
                    <c:set var="insertErr" value="${requestScope.INSERTERROR}"/>
                    <form action="insertProduct">
                        <tr>
                            <td>ID: </td>
                            <td><input type="text" name="txtID"/></td>
                            <td><c:if test="${not empty insertErr.idLengthErr}">
                                    <font color="red">${insertErr.idLengthErr}</font>
                                </c:if>
                            </td>
                        </tr>
                        <tr>
                            <td>Name: </td>
                            <td><input type="text" name="txtName"/></td>
                            <td><c:if test="${not empty insertErr.nameLengthErr}">
                                    <font color="red">${insertErr.nameLengthErr}</font>
                                </c:if>
                            </td>
                        </tr>
                        <tr>
                            <td>Unit: </td>
                            <td><input type="text" name="txtUnit"/></td>
                            <td><c:if test="${not empty insertErr.unitLengthErr}">
                                    <font color="red">${insertErr.unitLengthErr}</font>
                                </c:if>
                            </td>
                        </tr>
                        <tr>       
                            <td colspan="2">
                                <input type="submit" value="Insert" />
                            </td>

                        </tr>
                    </form>
                </table>
            </fieldset>
        </div>
        <div id="view">
            <c:set var="items" value="${sessionScope.ITEMS}"/>
            <c:set var="updateErr" value="${requestScope.UPDATEERROR}"/>
            <c:if test="${not empty updateErr.priceFormatErr}">
                <font color="red">${updateErr.priceFormatErr}</font>
            </c:if><br/>
            <c:if test="${not empty updateErr.unitLengthErr}">
                <font color="red">${updateErr.unitLengthErr}</font>
            </c:if>
            <c:if test="${not empty items}">
                
                <table border="1">
                    <thead>
                        <tr>
                            <th>No.</th>
                            <th>productName</th>
                            <th>price</th>
                            <th>quantity</th>
                            <th>unit</th>
                            <th>Update</th>
                            <th>Delete</th>
                            <th>Import</th>
                        </tr>
                    </thead>
                    <tbody>

                        <c:forEach var="pdto" items="${items}" varStatus="counter">                          
                            <tr>
                        <form action="updateProduct">

                            <td>${counter.count}</td>
                            <td>${pdto.productName}
                                <input type="hidden" name="pk" value="${pdto.productID}" />
                            </td>
                            <td>
                                <input type="number" name="txtPrice" value="${pdto.price}" />
                            </td>
                            <td>${pdto.quantity}</td>
                            <td>
                                <input type="text" name="txtUnit" value="${pdto.unit}" />
                            </td>
                            <td>
                                <input type="submit" value="Update" />
                            </td>
                        </form>
                        <form action="deleteProduct">
                            <td>
                                <input type="submit" value="Delete" />
                                <input type="hidden" name="pk" value="${pdto.productID}" />
                            </td>
                        </form>

                        <td>
                            <c:url var="importPage" value="import.jsp">
                                <c:param name="productName" value="${pdto.productName}"/>
                                <c:param name="productID" value="${pdto.productID}"/>
                            </c:url>
                            <a href="${importPage}">Import</a>
                        </td>

                        </tr>
                    </c:forEach>


                    </tbody>
                </table>


            </c:if>
            <c:if test="${empty items}">
                <h2>Empty product</h2>
            </c:if>

        </div>

    </body>
</html>
