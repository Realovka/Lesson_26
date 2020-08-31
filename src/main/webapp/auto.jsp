<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Authorization</title>
</head>
<body>
<form action="/auto" method="post">
    Login<input type="text" name="login">
    Password<input type="password" name="password">
    <button>Authorization</button>
</form>

</body>
</html>
