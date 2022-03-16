<%--
  Created by IntelliJ IDEA.
  User: OS
  Date: 3/14/2022
  Time: 11:29 AM
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

    <title>Update User</title>
</head>
<body>
<button><a href="/">Back to user list</a></button>
<div class="container">
    <form method="post" action="/UserList?action=update&id=${user.id}">
        <div class="form-group">
            <label for="input1">Edit name</label>
            <input type="text" class="form-control" id="input1" aria-describedby="emailHelp" placeholder="Enter name"
                   value="${user.name}" name="name">
            <small id="validateName" class="form-text text-muted">${error}</small>
        </div>
        <div class="form-group">
            <label for="input2">Edit email</label>
            <input type="text" class="form-control" id="input2" aria-describedby="emailHelp" placeholder="Enter email"
                   value="${user.email}" name="email">
            <small id="validateEmail" class="form-text text-muted">${error}</small>
        </div>
        <div class="form-group">
            <label for="input3">Edit country</label>
            <input type="text" class="form-control" id="input3" aria-describedby="emailHelp" placeholder="Enter country"
                   value="${user.country}" name="country">
            <small id="validateCountry" class="form-text text-muted">${error}</small>
        </div>
        <button type="submit" class="btn btn-primary">Submit</button>
    </form>
</div>
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
