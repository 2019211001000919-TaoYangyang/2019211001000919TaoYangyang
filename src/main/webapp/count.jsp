<%--
  Created by IntelliJ IDEA.
  User: 南渡
  Date: 2021/3/31
  Time: 17:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%!
    int getCount(){
        return ++count;
    }
%>

<%!
   int count = 0;
%>

<%
    out.println(getCount());
%>

</body>
</html>
