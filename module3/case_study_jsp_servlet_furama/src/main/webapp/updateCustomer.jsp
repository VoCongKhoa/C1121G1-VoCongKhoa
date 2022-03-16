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
<button><a href="/customer?action=list">Back to customer list</a></button>
<div class="container">
    <form method="post" action="/customer?action=update&idUpdate=${customer.customerId}">
        <div class="form-group">
            <label for="input1">Edit customer code</label>
            <input type="text" class="form-control" id="input1" aria-describedby="emailHelp"
                   value="${customer.customerCode}" name="customerCode">
            <small id="validateCustomerCode" class="form-text text-muted">${error}</small>
        </div>
        <div class="form-group">
            <label for="input2">Edit customer name</label>
            <input type="text" class="form-control" id="input2" aria-describedby="emailHelp"
                   value="${customer.customerName}" name="customerName">
            <small id="validateCustomerName" class="form-text text-muted">${error}</small>
        </div>
        <div class="form-group">
            <label for="input3">Edit customer birthday</label>
            <input type="text" class="form-control" id="input3" aria-describedby="emailHelp"
                   value="${customer.customerBirthday}" name="customerBirthday">
            <small id="validateCustomerBirthday" class="form-text text-muted">${error}</small>
        </div>
        <div class="form-group">
            <label for="input4">Edit customer gender</label>
            <input type="text" class="form-control" id="input4" aria-describedby="emailHelp"
                   value="${customer.customerGender}" name="customerGender">
            <small id="validateCustomerGender" class="form-text text-muted">${error}</small>
        </div>
        <div class="form-group">
            <label for="input5">Edit customer ID Card number</label>
            <input type="text" class="form-control" id="input5" aria-describedby="emailHelp"
                   value="${customer.customerIdCard}" name="customerIdCard">
            <small id="validateCustomerIdCard" class="form-text text-muted">${error}</small>
        </div>
        <div class="form-group">
            <label for="input6">Edit customer phone</label>
            <input type="text" class="form-control" id="input6" aria-describedby="emailHelp"
                   value="${customer.customerPhone}" name="customerPhone">
            <small id="validateCustomerPhone" class="form-text text-muted">${error}</small>
        </div>
        <div class="form-group">
            <label for="input7">Edit customer email</label>
            <input type="text" class="form-control" id="input7" aria-describedby="emailHelp"
                   value="${customer.customerEmail}" name="customerEmail">
            <small id="validateCustomerEmail" class="form-text text-muted">${error}</small>
        </div>
        <div class="form-group">
            <label for="input8">Edit customer address</label>
            <input type="text" class="form-control" id="input8" aria-describedby="emailHelp"
                   value="${customer.customerAddress}" name="customerAddress">
            <small id="validateCustomerAddress" class="form-text text-muted">${error}</small>
        </div>
        <c:set var="customerId" value="${customer.customerId}" />
        <div class="form-group">
            <label for="input9">Edit customer type id</label>
            <select name="customerTypeId" id="input9">
                <c:forEach var="typeId" items="${typeIdList}">
                    <c:choose>
                        <c:when test = "${typeId.customerTypeId == customer.customerTypeId}">
                            <option value="${typeId.customerTypeId}" selected>${typeId.customerTypeName}</option>
                        </c:when>
                        <c:otherwise>
                            <option value="${typeId.customerTypeId}">${typeId.customerTypeName}</option>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
            </select>
            <small id="validateCustomerTypeId" class="form-text text-muted">${error}</small>
        </div>
        <button type="submit" class="btn btn-primary">Submit</button>
    </form>
</div>

<p>${messageUpdate}</p>

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
