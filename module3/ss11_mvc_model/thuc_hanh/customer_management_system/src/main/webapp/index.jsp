<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 10/3/2022
  Time: 12:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Customer List</title>
</head>
<body>
<h1>Customers</h1>
<p>
  <a href="/customer?action=create">Create new customer</a>
</p>
<table border="1">
  <tr>
    <td>Name</td>
    <td>Email</td>
    <td>Address</td>
    <td>Edit</td>
    <td>Delete</td>
  </tr>
  <c:forEach items="${customerList}" var="customer">
    <tr>
      <td><a href="/customer?action=view&id=${customer.id}">${customer.name}</a></td>
      <td>${customer.email}</td>
      <td>${customer.address}</td>
      <td><a href="/customer?action=edit&id=${customer.id}">Edit</a></td>
      <td><a href="/customer?action=delete&id=${customer.id}">Delete</a></td>
    </tr>
  </c:forEach>
</table>
</body>
</html>

