<%@ page contentType="text/html;charset=utf-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Home Page</title>
</head>
<body>
Hello ${sessionScope.loginAuthorization}
<c:if test="${sessionScope.loginAuthorization!=null}">
    <a href="/logout">Logout</a>
</c:if>
<c:if test="${sessionScope.loginAuthorization==null}">
    <a href="/reg">Registration</a>
    <a href="/auto">Authorization</a>
</c:if>
</body>
</html>
