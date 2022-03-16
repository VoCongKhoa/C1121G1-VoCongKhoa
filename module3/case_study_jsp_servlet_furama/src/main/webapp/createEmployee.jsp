<%--
  Created by IntelliJ IDEA.
  User: OS
  Date: 3/14/2022
  Time: 9:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Create new employee</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
<%
    response.setCharacterEncoding("utf-8");
%>
<%--<a href="home.jsp">Back to homepage</a>--%>
<form method="post">
    <label for="name">Add new employee name:
        <input type="text" placeholder="Type new employee name" id="name" name="employeeNameCreate">
    </label><br><br>
    <label for="birthday">Add new employee birthday:
        <input type="text" placeholder="Type new employee birthday" id="birthday" name="employeeBirthdayCreate">
    </label><br><br>
    <label for="idCard">Add new employee id card:
        <input type="text" placeholder="Type new employee id card" id="idCard" name="employeeIdCardCreate">
    </label><br><br>
    <label for="salary">Add new employee salary:
        <input type="text" placeholder="Type new employee salary" id="salary" name="employeeSalaryCreate">
    </label><br><br>
    <label for="phone">Add new employee phone:
        <input type="text" placeholder="Type new employee phone" id="phone" name="employeePhoneCreate">
    </label><br><br>
    <label for="email">Add new employee email:
        <input type="text" placeholder="Type new employee email" id="email" name="employeeEmailCreate">
    </label><br><br>
    <label for="address">Add new employee address:
        <input type="text" placeholder="Type new employee address" id="address" name="employeeAddressCreate">
    </label><br><br>
    <label for="positionId">Choose new employee position:
        <select name="positionIdCreate" id="positionId">
            <option value="default" selected>Pick employee position</option>
            <c:forEach var="positionIdCreate" items="${positionListCreate}">
                <option value="${positionIdCreate.positionId}">${positionIdCreate.positionName}</option>
            </c:forEach>
        </select>
    </label><br><br>
    <label for="educationDegreeId">Choose new employee education degree:
        <select name="educationDegreeIdCreate" id="educationDegreeId">
            <option value="default" selected>Pick employee position</option>
            <c:forEach var="educationDegreeIdCreate" items="${educationDegreeListCreate}">
                <option value="${educationDegreeIdCreate.educationDegreeId}">${educationDegreeIdCreate.educationDegreeName}</option>
            </c:forEach>
        </select>
    </label><br><br>
    <label for="divisionId">Choose new employee division:
        <select name="divisionIdCreate" id="divisionId">
            <option value="default" selected>Pick employee position</option>
            <c:forEach var="divisionIdCreate" items="${divisionListCreate}">
                <option value="${divisionIdCreate.divisionId}">${divisionIdCreate.divisionName}</option>
            </c:forEach>
        </select>
    </label><br><br>
    <button type="submit">Submit</button>
</form>
<p>${messageCreate}</p>
</body>
</html>

<%--        <input type="text" placeholder="Type new employee type id" id="typeId" name="employeeTypeIdCreate">--%>

