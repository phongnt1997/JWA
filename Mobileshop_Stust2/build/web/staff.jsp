<%-- 
    Document   : staff
    Created on : Oct 18, 2017, 10:40:26 AM
    Author     : PhongNTSE1997
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Staff</title>
    </head>
    <body>
        <font color="red">
        welcome, <s:property value="%{#session.ACTOR.fullname}"/>
        </font>
        <h1>Staff Page</h1>
        <s:a href="logout">Logout</s:a>
        <s:form action="search">
            Search Product <s:textfield name="searchValue"/><br/>
            <s:submit value="Search"/>
            <s:a href="insert.jsp">Insert new mobile</s:a>
        </s:form>

        <s:if test="%{searchValue != null}">

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
                            <th>Delete</th>
                            <th>Update</th>

                        </tr>
                    </thead>
                    <tbody>
                        <s:iterator value="%{listMobile}" status="counter">
                            <s:form action="updateMobile" theme="simple">
                            <tr>
                                <td><s:property value="%{#counter.count}"/></td>
                                <td><s:property value="mobileID"/>
                                    <s:hidden name = "mobileID" value="%{mobileID}"/>
                                </td>
                                <td>
                                    <s:textfield name="description" value="%{description}"/>
                                </td>
                                <td><s:property value="mobileName"/></td>
                                <td>
                                    <s:textfield name="price" value="%{price}"/>
                                </td>
                                <td>
                                    <s:property value="yom"/>
                                </td>
                                <td>
                                    <s:textfield name="quantity" value="%{quantity}"/>
                                </td>
                                <td>
                                    <s:checkbox name="notSale" value="notSale"/>   
                                </td>
                                <td>                                 
                                    <s:url id="delLink" value="deleteMobile">
                                        <s:param name="pk" value="%{mobileID}"/>
                                        <s:param name="lastSearchValue" value="%{searchValue}"/>
                                    </s:url>
                                    <s:a href="%{delLink}">Delete</s:a>
                                    </td>
                                    <td>                                      
                                    <s:submit value="Update"/>
                                    <s:hidden name="lastSearchValue" value="%{searchValue}"/>
                                </td>
                            </tr>
                        </s:form>

                    </s:iterator>


                </tbody>
            </table>



        </s:if>
        <s:if test="%{listMobile == null}">
            <h2>No record matched!!</h2>
        </s:if>
    </s:if>

</body>
</html>
