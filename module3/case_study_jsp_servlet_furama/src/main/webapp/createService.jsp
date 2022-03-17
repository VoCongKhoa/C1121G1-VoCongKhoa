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
  <title>Create new service</title>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
<%
  response.setCharacterEncoding("utf-8");
%>
<%--<a href="home.jsp">Back to homepage</a>--%>
<form method="post">
  <label for="code">Add new service code:
    <input type="text" placeholder="Type new service code" id="code" name="serviceCodeCreate">
  </label><br><br>
  <label for="name">Add new service name:
    <input type="text" placeholder="Type new service name" id="name" name="serviceNameCreate">
  </label><br><br>
  <label for="area">Add new service area:
    <input type="text" placeholder="Type new service area" id="area" name="serviceAreaCreate">
  </label><br><br>
  <label for="cost">Add new service cost:
    <input type="text" placeholder="Type new service cost" id="cost" name="serviceCostCreate">
  </label><br><br>
  <label for="maxPeople">Add new service max people:
    <input type="text" placeholder="Type new service max people" id="maxPeople" name="serviceMaxPeopleCreate">
  </label><br><br>
  <label for="standardRoom">Add new standard room:
    <input type="text" placeholder="Type new standard room" id="standardRoom" name="standardRoomCreate">
  </label><br><br>
  <label for="description">Add new description other convenience:
    <input type="text" placeholder="Type new description other convenience" id="description" name="descriptionOtherConvenienceCreate">
  </label><br><br>
  <label for="poolArea">Add new pool area:
    <input type="text" placeholder="Type new pool area" id="poolArea" name="poolAreaCreate">
  </label><br><br>
  <label for="floors">Add new number of floors:
    <input type="text" placeholder="Type new number of floors" id="floors" name="numberOfFloorsCreate">
  </label><br><br>
  <label for="rentType">Choose new rent type:
    <select name="rentTypeIdCreate" id="rentType">
      <option value="default" selected>Pick rent type</option>
      <c:forEach var="rentTypeIdCreate" items="${rentTypeListCreate}">
        <option value="${rentTypeIdCreate.rentTypeId}">${rentTypeIdCreate.rentTypeName}</option>
      </c:forEach>
    </select>
  </label><br><br>
  <label for="serviceType">Choose new service type:
    <select name="serviceTypeIdCreate" id="serviceType">
      <option value="default" selected>Pick service type</option>
      <c:forEach var="serviceTypeIdCreate" items="${serviceTypeListCreate}">
        <option value="${serviceTypeIdCreate.serviceTypeId}">${serviceTypeIdCreate.serviceTypeName}</option>
      </c:forEach>
    </select>
  </label><br><br>
  <button type="submit">Submit</button>
</form>
<p>${messageCreate}</p>
</body>
</html>

<%--        <input type="text" placeholder="Type new service type id" id="typeId" name="serviceTypeIdCreate">--%>

