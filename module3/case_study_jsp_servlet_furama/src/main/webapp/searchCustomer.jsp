<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 13/3/2022
  Time: 1:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!doctype html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

    <title>List all customers</title>
</head>
<body>
<button><a href="/customer?action=list">Back to customer list</a></button>
<table border="1px" style="border-collapse: collapse">
    <tr>
        <th>ID</th>
        <th>Code</th>
        <th>Name</th>
        <th>Birthday</th>
        <th>Gender</th>
        <th>Id Card Number</th>
        <th>Phone</th>
        <th>Email</th>
        <th>Address</th>
        <th>Customer Type Id</th>
        <th>Customer Type Name</th>
    </tr>
    <c:forEach items="${customerListSearch}" var="customer">
        <tr>
            <td>${customer.customerId}</td>
            <td>${customer.customerCode}</td>
            <td>${customer.customerName}</td>
            <td>${customer.customerBirthday}</td>
            <td>${customer.customerGender}</td>
            <td>${customer.customerIdCard}</td>
            <td>${customer.customerPhone}</td>
            <td>${customer.customerEmail}</td>
            <td>${customer.customerAddress}</td>
            <td>${customer.customerTypeId}</td>
            <td>${customer.customerTypeName}</td>
        </tr>
    </c:forEach>
</table>

<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
        integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"
        integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"
        integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
        crossorigin="anonymous"></script>
</body>
</html>
