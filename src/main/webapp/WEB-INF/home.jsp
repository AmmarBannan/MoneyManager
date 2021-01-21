<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Welcome Page</title>
</head>
<body>
<h1>Welcome Page <c:out value="${currentUser.username}"></c:out></h1>
<a href="/user">Setting</a>
<form id="logoutForm" method="POST" action="/logout">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    <input type="submit" value="Logout!"/>
</form>

<a href="/incomes/new">Addincome</a>
<a href="/plan/new">add plan</a>
<table>
    <thead>
        <tr><th>Amount</th><th>description</th><th>date</th></tr>
    </thead>
    <tbody>
    <c:forEach items="${ incomes }" var="income">
        <tr>
            <td>${ income.amount }</td>
            <td>${ income.description}</td>
            <td>${ income.createdAt}</td>
        </tr>
    </c:forEach>
    </tbody>

</table>

<h3>plan</h3>
<table>
    <thead>
    <tr><th>name</th><th>data</th><th>maxlimit</th></tr>
    </thead>
    <tbody>
    <c:forEach items="${ plans }" var="plan">
        <tr>
            <td>${ plan.name }</td>
            <td>${ plan.startdate}  ${ plan.enddate}</td>
            <td>${ plan.maxlimit}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
