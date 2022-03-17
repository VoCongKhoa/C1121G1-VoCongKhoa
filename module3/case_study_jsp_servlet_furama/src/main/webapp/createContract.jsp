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
    <title>Create new contract</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
<%
    response.setCharacterEncoding("utf-8");
%>
<%--<a href="home.jsp">Back to homepage</a>--%>
<form method="post">
    <label for="startDate">Select new contract start date:
        <input type="date" id="startDate" name="contractStartDateCreate">
    </label><br><br>
    <label for="endDate">Select new contract end date:
        <input type="date" id="endDate" name="contractEndDateCreate">
    </label><br><br>
    <label for="deposit">Add new contract deposit:
        <input type="text" placeholder="Type new contract deposit" id="deposit" name="contractDepositCreate">
    </label><br><br>
    <label for="totalMoney">Add new contract total money:
        <input type="text" placeholder="Type new contract total money" id="totalMoney" name="contractTotalMoneyCreate">
    </label><br><br>
    <div>
        <label for="employeeId">Add new employee id:
            <input type="text" placeholder="Type new employee id" id="employeeId" name="employeeIdCreate">
        </label><br><br>
        <small id="validateEmployeeId" class="form-text text-muted">${error}</small>
    </div>
    <div>
        <label for="customerId">Add new customer id:
            <input type="text" placeholder="Type new customer id" id="customerId" name="customerIdCreate">
        </label><br><br>
        <small id="validateCustomerId" class="form-text text-muted">${error}</small>
    </div>
    <label for="serviceId">Choose new service:
        <select name="serviceIdCreate" id="serviceId">
            <option value="default" selected>Pick service</option>
            <c:forEach var="serviceIdCreate" items="${serviceListCreate}">
                <option value="${serviceIdCreate.serviceId}">${serviceIdCreate.serviceName}</option>
            </c:forEach>
        </select>
    </label><br><br>
    <button type="submit">Submit</button>
</form>
<p>${messageCreate}</p>
</body>
</html>

<%--        <input type="text" placeholder="Type new contract type id" id="typeId" name="contractTypeIdCreate">--%>

