<%--
  Created by IntelliJ IDEA.
  User: 南渡
  Date: 2021/3/30
  Time: 22:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>首页</title>
</head>
<body>
<%@include file="header.jsp"%>
<h1>Welcome Come to My Home Page!</h1>
<form action="search" target="_blank" method="get">
    <input type="text" name="txt" size="30"/>
    <select name="search">
        <option value="baidu">Baidu</option>
        <option value="bing">Bing</option>
        <option value="google">Google</option>
    </select>
    <input type="submit" value="Search">
</form>
<%@include file="footer.jsp"%>
</body>
</html>
