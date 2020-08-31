<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>History</title>
</head>
<body>
<h3>History</h3>
<c:forEach items="${sessionScope.resultList}" var="item">
    <p>${item}</p>
</c:forEach>
</body>
</html>
