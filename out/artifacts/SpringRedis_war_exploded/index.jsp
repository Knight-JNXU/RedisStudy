<%--
  Created by IntelliJ IDEA.
  User: Knigh
  Date: 2016/11/14
  Time: 20:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>index</title>
</head>
<body>
<form action="<%=request.getContextPath()%>/web/input" method="post">
    input web:
    <p><label>url:</label><input type="text" name="url"></p>
    <p><label>des:</label><input type="text" name="des"></p>
    <br><input type="submit" value="submit">
</form>
</body>
</html>
