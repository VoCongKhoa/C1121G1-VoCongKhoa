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
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <h1 class="text-center">Customers</h1>
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
                <td><a href="/customer?action=edit&id=${customer.id}" class="btn btn-primary">Edit</a></td>
                    <%--            <td><a href="/customer?action=delete&id=${customer.id}" class="btn btn-primary" data-toggle="modal"--%>
                    <%--                   data-target="#exampleModal">--%>
                    <%--                Delete--%>
                    <%--            </a></td>--%>
                <td><a href="/customer?action=delete&id=${customer.id}" class="btn btn-primary">Delete</a></td>
                    <%--            <td><a href="/customer?action=delete&id=${customer.id}">Delete</a></td>--%>
            </tr>
        </c:forEach>
    </table>
</div>
<!-- Button trigger modal -->
<%--<a href="https://google.com/" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal">--%>
<%--    Launch demo modal--%>
<%--</a>--%>

<!-- Modal -->
<%--<div class="modal fade" id="confirm-delete" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"--%>
<%--     aria-hidden="true">--%>
<%--    <div class="modal-dialog" role="document">--%>
<%--        <div class="modal-content">--%>
<%--            <form method="post" action="" >--%>
<%--                <div class="modal-header">--%>
<%--                    <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>--%>
<%--                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">--%>
<%--                        <span aria-hidden="true">&times;</span>--%>
<%--                    </button>--%>
<%--                </div>--%>
<%--                <div class="modal-body">--%>
<%--                    Do you want to delete??--%>
<%--                </div>--%>
<%--                <div class="modal-footer">--%>
<%--                    <button type="button" class="btn btn-secondary" data-dismiss="modal">NO</button>--%>
<%--                    <button type="submit" class="btn btn-primary" id="1">YES</button>--%>
<%--                </div>--%>
<%--            </form>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--</div>--%>

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

