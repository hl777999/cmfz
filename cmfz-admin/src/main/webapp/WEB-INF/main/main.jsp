<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/7/4
  Time: 15:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>登录成功! 欢迎${sessionScope.manager.mgrname} 你的权限等级是${sessionScope.manager.mgrstatus}</h1>
    <input type="button" value="注销" onclick="location='${pageContext.request.contextPath}/manager/logout'">
</body>
</html>
