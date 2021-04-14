<%--
  Created by IntelliJ IDEA.
  User: 南渡
  Date: 2021/3/30
  Time: 18:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%@include file="header.jsp"%>
<h1>Login</h1>
<form action="${pageContext.request.contextPath}/login" method="post">
    username: <input type="text" name="username" required/><br>
    password: <input type="password" name="password" required/><br>
    <input type="submit" value="login"><br>
    <span style="color: red;font-size: small">${requestScope.msg}</span>
</form>
<%@include file="footer.jsp"%>
</body>
</html>
