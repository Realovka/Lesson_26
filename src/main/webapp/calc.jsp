<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Calculation</title>
</head>
<body>
<form action="/calc" method="get">
    <c:if test="${sessionScope.num1==null}">
        Число номер 1<input type="number" name="num1"/>
        Действие: <select name="type">
        <option>+</option>
        <option>-</option>
        <option>*</option>
        <option>/</option>
    </select>
        Число номер 2<input type="number" name="num2"/>
        <input type="submit"/>
        <input type="number" name="result" value="${sessionScope.result}"/>
        <a href="/history.jsp">History</a>
    </c:if>
    <c:if test="${sessionScope.num1!=null && sessionScope.type.equals('+')}">
        Число номер 1<input type="number" name="num1" value="${sessionScope.num1}"/>
        Действие: <select name="type">
        <option selected="selected">+</option>
        <option>-</option>
        <option>*</option>
        <option>/</option>
    </select>
        Число номер 2<input type="number" name="num2" value="${sessionScope.num2}">
        <input type="submit">
        <input type="number" name="result" value="${sessionScope.result}">
        <a href="/history.jsp">History</a>
    </c:if>
    <c:if test="${sessionScope.num1!=null && sessionScope.type.equals('/')}">
        Число номер 1<input type="number" name="num1" value="${sessionScope.num1}">
        Действие: <select name="type">
        <option>+</option>
        <option>-</option>
        <option>*</option>
        <option selected="selected">/</option>
    </select>
        Число номер 2<input type="number" name="num2" value="${sessionScope.num2}">
        <input type="submit">
        <input type="number" name="result" value="${sessionScope.result}">
        <a href="/history.jsp">History</a>
    </c:if>
    <c:if test="${sessionScope.num1!=null && sessionScope.type.equals('*')}">
        Число номер 1<input type="number" name="num1" value="${sessionScope.num1}">
        Действие: <select name="type">
        <option>+</option>
        <option>-</option>
        <option selected="selected">*</option>
        <option>/</option>
    </select>
        Число номер 2<input type="number" name="num2" value="${sessionScope.num2}">
        <input type="submit">
        <input type="number" name="result" value="${sessionScope.result}">
        <a href="/history.jsp">History</a>
    </c:if>
    <c:if test="${sessionScope.num1!=null && sessionScope.type.equals('-')}">
        Число номер 1<input type="number" name="num1" value="${sessionScope.num1}">
        Действие: <select name="type">
        <option>+</option>
        <option selected="selected">-</option>
        <option>*</option>
        <option>/</option>
    </select>
        Число номер 2<input type="number" name="num2" value="${sessionScope.num2}">
        <input type="submit">
        <input type="number" name="result" value="${sessionScope.result}">
        <a href="/history.jsp">History</a>
    </c:if>
</form>

</body>
</html>
