<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 10/3/2022
  Time: 10:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>View customer</title>
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
<h1 style="text-align: center;">Customer details</h1>
<table>
    <tr>
        <td>Name:</td>
        <td>${customer.name}</td>
    </tr>
    <tr>
        <td>Email:</td>
        <td>${customer.email}</td>
    </tr>
    <tr>
        <td>Address:</td>
        <td>${customer.address}</td>
    </tr>
</table>
<p>
    <a href="/customer">Back to customer list</a>
</p>
</body>
</html>
