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
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <title>Employee List</title>
</head>
<body>
<button><a href="/employee?action=create">Create new employee</a></button>

<%--SEARCH--%>
<form method="get">
    <input type="hidden" name="action" value="search">
    <input type="text" placeholder="Search by employee name" name="employeeNameSearch">
    <button type="submit">Search</button>
</form>

<%--SORT--%>
<form method="get" id="sortForm" onchange="submitSortForm()">
    <label for="sort">Sort</label>
    <select name="action" id="sort">
        <option value="default" selected>Sort</option>
        <option value="idSort">Sort by Id</option>
        <option value="nameSort">Sort by Name</option>
        <option value="birthdaySort">Sort by Birthday</option>
        <option value="salarySort">Sort by Salary</option>
    </select>
</form>
<table border="1px" style="border-collapse: collapse">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Birthday</th>
        <th>Id Card Number</th>
        <th>Salary</th>
        <th>Phone</th>
        <th>Email</th>
        <th>Address</th>
        <th>Employee Position Id</th>
        <th>Employee Education Degree Id</th>
        <th>Employee Division Id</th>
        <th>Employee Username</th>
        <th colspan="2">Feature</th>
    </tr>
    <c:forEach items="${employeeList}" var="employee">
        <tr>
            <td>${employee.employeeId}</td>
            <td>${employee.employeeName}</td>
            <td>${employee.employeeBirthday}</td>
            <td>${employee.employeeIdCard}</td>
            <td>${employee.employeeSalary}</td>
            <td>${employee.employeePhone}</td>
            <td>${employee.employeeEmail}</td>
            <td>${employee.employeeAddress}</td>
            <td>${employee.positionId}</td>
            <td>${employee.educationDegreeId}</td>
            <td>${employee.divisionId}</td>
            <td>${employee.username}</td>
            <td>
                <button><a href="/employee?action=update&id=${employee.employeeId}">Edit</a ></button>
            </td>
            <td><a href="#" type="button" class="btn btn-primary"
                   data-toggle="modal" data-target="#exampleModal" onclick="getId(${employee.employeeId})">
                Delete
            </a></td>
                <%--            /employee?action=delete&id=${employee.employeeId}--%>
        </tr>
    </c:forEach>
</table>

<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
     aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <form method="post" action="/employee?action=delete">
                <input type="hidden" name="idEmployeeDelete" id="idGet">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    ...
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                    <button type="submit" class="btn btn-primary">Save changes</button>
                </div>
            </form>
        </div>
    </div>
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
<script>
    function getId(id) {
        document.getElementById("idGet").value = id;
    }
    function submitSortForm() {
        document.getElementById("sortForm").submit();
    }
</script>
</html>
