<%@ page import="com.TaoYangyang.Model.User" %><%--
  Created by IntelliJ IDEA.
  User: 南渡
  Date: 2021/4/6
  Time: 22:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>userInfo</title>
</head>
<body>
<%
    Cookie[] cookies = request.getCookies();
    for (Cookie cookie : cookies) {
        out.println("<br/>" + cookie.getName() + "-----" + cookie.getValue());
    }
%>

<%@include file="header.jsp"%>
    <table border="1"  style="text-align: center">
        <tr>
        <td>Username</td>
        <td>Password</td>
        <td>Email</td>
        <td>Gender</td>
        <td>Birth Date</td>
        <td>operation</td>
        </tr>
        <tr>
    <%
        User user = (User) session.getAttribute("user");
    %>
            <td><%=user.getUsername()%></td>
            <td><%=user.getPassword()%></td>
            <td><%=user.getEmail()%></td>
            <td><%=user.getGender()%></td>
            <td><%=user.getBirth()%></td>
            <td><a href="updateUser?id=<%=user.getId()%>">update</a></td>
        </tr>
    </table>
<%@include file="footer.jsp"%>
</body>
</html>
