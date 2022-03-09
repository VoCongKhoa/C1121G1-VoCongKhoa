<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 9/3/2022
  Time: 8:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calculator</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
<h1 style="text-align: center">Simple Calculator</h1>
<div class="container">
<form method="get" action="/calculate">
    <div class="form-group">
        <label for="exampleInputEmail1">First operator</label>
        <input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp"
               placeholder="Enter first operator" name="first">
    </div>
    <div class="form-group">
        <label for="exampleFormControlSelect1">Operator</label>
        <select class="form-control" id="exampleFormControlSelect1" name="operator">
            <option selected value="+">+</option>
            <option value="-">-</option>
            <option value="x">x</option>
            <option value=":">:</option>
        </select>
    </div>
    <div class="form-group">
        <label for="exampleInputEmail2">Second operator</label>
        <input type="text" class="form-control" id="exampleInputEmail2" aria-describedby="emailHelp"
               placeholder="Enter second operator" name="second">
    </div>
    <button type="submit" class="btn btn-primary">Submit</button>
</form>
<p style="color: red; text-align: center; font-size: x-large">${error}</p>
</div>

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
