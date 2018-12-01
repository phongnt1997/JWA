<%-- 
    Document   : import
    Created on : Oct 23, 2017, 8:41:52 PM
    Author     : PhongNTSE1997
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<style>
    div {float: left}
    #cancel {width: 40%}
    #save {width: 60%}
    #cancel input {width: 100%}
    #save input {width: 100%}
</style>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Import</title>
    </head>
    <body>
        <h1>Import Products</h1>
        <c:set var="importErr" value="${requestScope.IMPORTERROR}"/>
        <table>
            <tbody>
            <form action="importProduct">
                <tr>
                    <td>Product name: </td>
                    <td>${param.productName}
                        <input type="hidden" name="productID" value="${param.productID}" />
                        <input type="hidden" name="productName" value="${param.productName}" />
                    </td>
                </tr>
                <tr>
                    <td>Price:</td>
                    <td>
                        <input type="number" name="txtPrice" value="" />
                    </td>
                    <td>
                        <c:if test="${not empty importErr.priceFormatErr}">
                            <font color="red">${importErr.priceFormatErr}</font>
                        </c:if>
                    </td>
                </tr>
                <tr>
                    <td>Quantity</td>
                    <td>
                        <input type="number" name="txtQuantity" value="" />
                    </td>
                    <td>
                        <c:if test="${not empty importErr.quantityFormatErr}">
                            <font color="red">${importErr.quantityFormatErr}</font>
                        </c:if>
                    </td>
                </tr>
                <tr>
                    <td></td>
                    <td>
                        <div id="save"><input type="submit" value="Save"/>
            </form> 
        </div>
        <div id="cancel">
            <form action="product.jsp">
                <input type="submit" value="Cancel" />
            </form>
        </div>

    </td>
</tr>

</tbody>
</table>

</body>
</html>
