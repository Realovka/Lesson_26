<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Registration</title>
</head>
<body>
<form action="/reg" method="post">
    Login<input type="text" name="login">
    Password<input type="password" name="password">
    Name<input type="text" name="name">
    <button>Registration</button>
    <c:if test="${sessionScope.errorRegistration!=null}">
        <p>${sessionScope.errorRegistration}</p>
    </c:if>

</form>
</body>
</html>
