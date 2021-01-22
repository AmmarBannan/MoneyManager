<%--
  Created by IntelliJ IDEA.
  User: Ammar
  Date: 1/23/2021
  Time: 12:29 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="/incomes">Dashboard</a>
<h1>Welcome Page <c:out value="${username}"></c:out></h1>
<h3><c:out value="${ error }" /></h3>
<form:form action="/category/new" method="POST" modelAttribute="category">
    <p>
        <form:label path="name">limit Money</form:label>
        <form:input type="text" path="name" class="input" />
    </p>
    <input type="submit" value="Submit"/>
</form:form>
</body>
</html>
