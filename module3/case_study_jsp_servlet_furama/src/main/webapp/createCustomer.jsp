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
    <title>Create new customer</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
<%
    response.setCharacterEncoding("utf-8");
%>
<%--<a href="home.jsp">Back to homepage</a>--%>
<form method="post">
    <label for="code">Add new customer code:
        <input type="text" placeholder="Type new customer code" id="code" name="customerCodeCreate">
    </label><br><br>
    <label for="name">Add new customer name:
        <input type="text" placeholder="Type new customer name" id="name" name="customerNameCreate">
    </label><br><br>
    <label for="birthday">Select new customer birthday:
        <input type="date" id="birthday" name="customerBirthdayCreate">
    </label><br><br>

    <p>Choose customer gender:</p>
    <input type="radio" id="female" name="customerGenderCreate" value="0">
    <label for="female">Female</label><br>
    <input type="radio" id="male" name="customerGenderCreate" value="1">
    <label for="male">Male</label><br>

    <label for="idCard">Add new customer ID Card number:
        <input type="text" placeholder="Type new customer ID Card number" id="idCard" name="customerIdCardCreate">
    </label><br><br>
    <label for="phone">Add new customer phone:
        <input type="text" placeholder="Type new customer phone" id="phone" name="customerPhoneCreate">
    </label><br><br>
    <label for="email">Add new customer email:
        <input type="text" placeholder="Type new customer email" id="email" name="customerEmailCreate">
    </label><br><br>
    <label for="address">Add new customer address:
        <input type="text" placeholder="Type new customer address" id="address" name="customerAddressCreate">
    </label><br><br>
    <label for="typeId">Choose new customer type id:
        <select name="customerTypeIdCreate" id="typeId">
            <option value="default" selected>Pick customer type</option>
            <c:forEach var="typeIdCreate" items="${typeIdListCreate}">
                <option value="${typeIdCreate.customerTypeId}">${typeIdCreate.customerTypeName}</option>
            </c:forEach>
        </select>
    </label><br><br>
    <button type="submit">Submit</button>
</form>
<p>${messageCreate}</p>
</body>
</html>

<%--        <input type="text" placeholder="Type new customer type id" id="typeId" name="customerTypeIdCreate">--%>

