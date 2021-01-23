
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="/incomes">Dashboard</a>
<h1>Welcome Page <c:out value="${user.username}"></c:out></h1>
<h3><c:out value="${ error }" /></h3>

<form:form action="/expense/new" method="POST" modelAttribute="expense">
    <p>
        <form:label path="amount">limit Money</form:label>
        <form:input type="number" path="amount" class="input" />
    </p>
    <p>
        <form:label path="description">description</form:label>
        <form:errors path="description"/>
        <form:input path="description"/>
    </p>
    <p>
        <form:label path="date">date</form:label>
        <form:errors path="date"/>
        <form:input  path="date" type="date"/>
    </p>
    <p>
<<<<<<< HEAD
        <form:select  path="category">
            <c:forEach items="${ categories }" var="category">
                <option value="${ category.id }">${ category.name }</option>
            </c:forEach>
        </form:select>
=======
    <form:select  path="category">
        <c:forEach items="${ categories }" var="category">
            <option value="${ category.id }">${ category.name }</option>
        </c:forEach>
    </form:select>
>>>>>>> b59787f4103aa518a01d69b83b5af0496316177d
    </p>
    <input type="submit" value="Submit"/>
</form:form>

</body>
</html>