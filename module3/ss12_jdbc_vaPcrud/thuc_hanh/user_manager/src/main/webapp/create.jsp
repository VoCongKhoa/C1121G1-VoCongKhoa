<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 13/3/2022
  Time: 4:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Add new user</title>
</head>
<body>
<a href="/">Back to homepage</a>
<form method="post">
    <label for="name">Add new name:
        <input type="text" placeholder="Type new name" id="name" name="name">
    </label><br><br>
    <label for="email">Add new email:
        <input type="text" placeholder="Type new email" id="email" name="email">
    </label><br><br>
    <label for="country">Add new country:
        <input type="text" placeholder="Type new country" id="country" name="country">
    </label><br><br>
    <button type="submit">Submit</button>
</form>
</body>
</html>
