<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 9/3/2022
  Time: 1:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Product Discount Calculator</title>
  </head>
  <body>
  <form action="/discount" method="post">
    <label>Product Description:
      <input type="text" name="description" placeholder="Mô tả của sản phẩm">
    </label><br><br>
    <label>List Price:
      <input type="text" name="price" placeholder="Giá niêm yết của sản phẩm">
    </label><br><br>
    <label>Discount Percent:
      <input type="text" name="discount-percent" placeholder="Tỷ lệ chiết khấu (phần trăm)">
    </label><br><br>
    <input type="submit" value="Calculate Discount">
  </form>
  </body>
</html>
