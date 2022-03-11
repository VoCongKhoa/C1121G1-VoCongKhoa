<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 11/3/2022
  Time: 12:41 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit product</title>
</head>
<body>
<h1 style="text-align: center">Edit product</h1>
<p>
    <a href="/product">Back to product list</a>
</p>
<form method="post" action="/product?action=update&idUpdate=${product.id}">
    <fieldset>
        <legend>Product information</legend>
        <table>
            <tr>
                <td>Name: </td>
                <td><input type="text" name="name" value="${product.name}"></td>
            </tr>
            <tr>
                <td>Price: </td>
                <td><input type="text" name="price" value="${product.price}"></td>
            </tr>
            <tr>
                <td>Description: </td>
                <td><input type="text" name="description" value="${product.description}"></td>
            </tr>
            <tr>
                <td>Producer: </td>
                <td><input type="text" name="producer" value="${product.producer}"></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Update product"></td>
            </tr>
        </table>
    </fieldset>
</form>
<c:out value="${message}"></c:out>
</body>
</html>
