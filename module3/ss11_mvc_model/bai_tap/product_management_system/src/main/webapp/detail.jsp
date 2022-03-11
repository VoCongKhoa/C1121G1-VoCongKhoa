<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 11/3/2022
  Time: 2:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>View product</title>
    <style>
        h1 {
            text-align: center;
        }

        table {
            padding-left: 5%;
        }

        tr {
            height: 30px;
        }
    </style>
</head>
<body>
<h1 style="text-align: center;">Product details</h1>
<table>
    <tr>
        <td>Name:</td>
        <td>${product.name}</td>
    </tr>
    <tr>
        <td>Price:</td>
        <td>${product.price}</td>
    </tr>
    <tr>
        <td>Description:</td>
        <td>${product.description}</td>
    </tr>
    <tr>
        <td>Producer:</td>
        <td>${product.producer}</td>
    </tr>
</table>
<p>
    <a href="/product">Back to product list</a>
</p>
</body>
</html>
