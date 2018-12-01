<%-- 
    Document   : search
    Created on : Oct 26, 2017, 7:28:24 AM
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
        <h1>Search Page</h1>
        <s:form action="searchPet">
            Pet name <s:textfield name="searchValue"/>
            <s:submit value="Search"/>
        </s:form>
            
            <s:if test="%{searchValue.length() > 0}">
             
            <s:if test="%{listPet != null}">
                <table border="1">
                    <thead>
                        
                        <tr>
                            <th>No.</th>
                            <th>PetName</th>
                            <th>Description</th>
                            <th>Date if birth</th>
                            <th>Vaccine Des</th>
                            <th>Price</th>
                            <th>Buy</th>
                        </tr>
                    </thead>
                    <tbody>
                       
                        <s:iterator var="dto" value="%{listPet}" status="counter">
                            <tr>
                                <td>
                                    <s:property value="%{#counter.count}"/>
                                </td>
                                <td>
                                    <s:property value="%{#dto.petName}"/>
                                </td>
                                <td>
                                     <s:property value="%{#dto.description}"/>
                                </td>
                                <td>
                                    <s:property value="%{#dto.dob}"/>
                                </td>
                                <td>
                                    <s:property value="%{#dto.vaccineDesp}"/>
                                </td>
                                <td>
                                    <s:property value="%{#dto.price}"/>
                                </td>
                                <td>
                                    <a href="addToCart">Buy</a>
                                </td>
                            </tr>
                        </s:iterator>

                    </tbody>
                </table>

            </s:if>
        </s:if>
    </body>
</html>
