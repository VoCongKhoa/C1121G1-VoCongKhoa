<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.io.PrintWriter" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 9/3/2022
  Time: 3:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Simple Dictionary</title>
</head>
<body>
<%!
    Map<String, String> dictionaryMap = new HashMap<>();
%>
<%
    PrintWriter printWriter = response.getWriter();
    dictionaryMap.put("one", "Một");
    dictionaryMap.put("two", "Hai");
    dictionaryMap.put("three", "Ba");
    dictionaryMap.put("hello", "Xin chào");
    dictionaryMap.put("how", "Thế nào");
    dictionaryMap.put("book", "Quyển vở");
    dictionaryMap.put("computer", "Máy tính");
    String textSearch = request.getParameter("textSearch");
    String result = dictionaryMap.get(textSearch);
    if(result != null){
        printWriter.println("Word: " + textSearch);
        printWriter.println("Result: " + result);
    } else {
        printWriter.println("Not found");
    }
//        response.setCharacterEncoding("utf-8"); Hoặc dùng dòng này vẫn ok
%>
</body>
</html>
