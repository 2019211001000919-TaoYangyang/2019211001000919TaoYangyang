<%@ page import="com.TaoYangyang.Model.User" %><%--
  Created by IntelliJ IDEA.
  User: 南渡
  Date: 2021/4/20
  Time: 20:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>updateUser</title>
</head>
<body>
<%
    User userInfo = (User) request.getAttribute("userInfo");
    pageContext.setAttribute("userInfo",userInfo);
%>
<%@include file="header.jsp"%>
<span style="color: red">${requestScope.get("message")}</span>
<form action="updateUser" method="post">
    <input type="hidden" name="id" value="${userInfo.id}">
    username: <input type="text" name="username" value="${userInfo.username}"><br>
    password: <input type="text" name="password" value="${userInfo.password}"><br>
    email: <input type="email" name="email" value="${userInfo.email}"><br>
    gender: <input type="radio" name="gender" <%=userInfo.getGender().equals("Male")?"checked":""%> > Male
    <input type="radio" name="gender" <%=userInfo.getGender().equals("Female")?"checked":""%>> Female
    <br>
    birth: <input type="date" name="birth" value="${userInfo.birth}"><br>
    <input type="submit" value="update">
</form>
<%@include file="footer.jsp"%>
</body>
</html>
