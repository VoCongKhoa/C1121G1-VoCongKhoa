<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 9/3/2022
  Time: 1:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<html>
<head>
  <title>Simple Dictionary</title>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
<h2>Vietnamese Dictionary</h2>
<form method="get" action="/translate">
  <input type="text" name="textSearch" placeholder="Enter your word: "/>
  <input type = "submit" id = "submit" value = "Search"/>
</form>
</body>
</html>
