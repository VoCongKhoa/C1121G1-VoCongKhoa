<%--
  Created by IntelliJ IDEA.
  User: OS
  Date: 3/14/2022
  Time: 9:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Customer List</title>
</head>
<body>
<button><a href="/customer?action=create">Create new user</a></button>
<table border="1px" style="border-collapse: collapse">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Birthday</th>
        <th>Gender</th>
        <th>Id Card Number</th>
        <th>Phone</th>
        <th>Email</th>
        <th>Address</th>
        <th>Customer Type Id</th>
        <th colspan="2">Feature</th>
    </tr>
    <c:forEach items="${customerList}" var="customer">
        <tr>
            <td>${customer.customerId}</td>
            <td>${customer.customerName}</td>
            <td>${customer.customerBirthday}</td>
            <td>${customer.customerGender}</td>
            <td>${customer.customerIdCard}</td>
            <td>${customer.customerPhone}</td>
            <td>${customer.customerEmail}</td>
            <td>${customer.customerAddress}</td>
            <td>${customer.customerTypeId}</td>
            <td>
                <button><a href="/UserList?action=update&id=${customer.customerId}">Edit</a></button>
            </td>
            <td><a href="/UserList?action=delete&id=${customer.customerId}" type="button" class="btn btn-primary"
                   data-toggle="modal" data-target="#exampleModal" onclick="getId(${customer.customerId})">
                Delete
            </a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
