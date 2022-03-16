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

    <title>Update Employee</title>
</head>
<body>
<button><a href="/employee?action=list">Back to employee list</a></button>
<div class="container">
    <form method="post" action="/employee?action=update&id=${employee.employeeId}">
        <div class="form-group">
            <label for="input1">Edit employee name</label>
            <input type="text" class="form-control" id="input1" aria-describedby="emailHelp"
                   value="${employee.employeeName}" name="employeeNameUpdate">
            <small id="validateCustomerCode" class="form-text text-muted">${error}</small>
        </div>
        <div class="form-group">
            <label for="input2">Edit employee birthday</label>
            <input type="text" class="form-control" id="input2" aria-describedby="emailHelp"
                   value="${employee.employeeBirthday}" name="employeeBirthdayUpdate">
            <small id="validateCustomerName" class="form-text text-muted">${error}</small>
        </div>
        <div class="form-group">
            <label for="input3">Edit employee id card</label>
            <input type="text" class="form-control" id="input3" aria-describedby="emailHelp"
                   value="${employee.employeeIdCard}" name="employeeIdCardUpdate">
            <small id="validateCustomerBirthday" class="form-text text-muted">${error}</small>
        </div>
        <div class="form-group">
            <label for="input4">Edit employee salary</label>
            <input type="text" class="form-control" id="input4" aria-describedby="emailHelp"
                   value="${employee.employeeSalary}" name="employeeSalaryUpdate">
            <small id="validateCustomerGender" class="form-text text-muted">${error}</small>
        </div>
        <div class="form-group">
            <label for="input5">Edit employee phone</label>
            <input type="text" class="form-control" id="input5" aria-describedby="emailHelp"
                   value="${employee.employeePhone}" name="employeePhoneUpdate">
            <small id="validateCustomerIdCard" class="form-text text-muted">${error}</small>
        </div>
        <div class="form-group">
            <label for="input6">Edit employee email</label>
            <input type="text" class="form-control" id="input6" aria-describedby="emailHelp"
                   value="${employee.employeeEmail}" name="employeeEmailUpdate">
            <small id="validateCustomerPhone" class="form-text text-muted">${error}</small>
        </div>
        <div class="form-group">
            <label for="input7">Edit employee address</label>
            <input type="text" class="form-control" id="input7" aria-describedby="emailHelp"
                   value="${employee.employeeAddress}" name="employeeAddressUpdate">
            <small id="validateCustomerEmail" class="form-text text-muted">${error}</small>
        </div>
        <div class="form-group">
            <label for="input8">Edit employee position id</label>
            <select name="employeePositionId" id="input8">
                <c:forEach var="employeePosition" items="${employeePositionListUpdate}">
                    <c:choose>
                        <c:when test = "${employeePosition.positionId == employee.positionId}">
                            <option value="${employeePosition.positionId}" selected>${employeePosition.positionName}</option>
                        </c:when>
                        <c:otherwise>
                            <option value="${employeePosition.positionId}">${employeePosition.positionName}</option>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
            </select>
            <small id="validateEmployeePositionId" class="form-text text-muted">${error}</small>
        </div>
        <div class="form-group">
            <label for="input9">Edit employee education degree id</label>
            <select name="employeeEducationDegreeId" id="input9">
                <c:forEach var="employeeEducationDegree" items="${employeeEducationDegreeListUpdate}">
                    <c:choose>
                        <c:when test = "${employeeEducationDegree.educationDegreeId == employee.educationDegreeId}">
                            <option value="${employeeEducationDegree.educationDegreeId}" selected>${employeeEducationDegree.educationDegreeName}</option>
                        </c:when>
                        <c:otherwise>
                            <option value="${employeeEducationDegree.educationDegreeId}">${employeeEducationDegree.educationDegreeName}</option>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
            </select>
            <small id="validateEmployeeEducationDegreeId" class="form-text text-muted">${error}</small>
        </div>
        <div class="form-group">
            <label for="input10">Edit employee division id</label>
            <select name="employeeDivisionId" id="input10">
                <c:forEach var="employeeDivision" items="${employeeDivisionListUpdate}">
                    <c:choose>
                        <c:when test = "${employeeDivision.divisionId == employee.divisionId}">
                            <option value="${employeeDivision.divisionId}" selected>${employeeDivision.divisionName}</option>
                        </c:when>
                        <c:otherwise>
                            <option value="${employeeDivision.divisionId}">${employeeDivision.divisionName}</option>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
            </select>
            <small id="validateEmployeeDivisionId" class="form-text text-muted">${error}</small>
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
